package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder output = new StringBuilder();

        TownSeedDto[] fromJson = this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class);

        Arrays
                .stream(fromJson)
                .filter(townSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(townSeedDto) &&
                            !doesEntityExist(townSeedDto.getTownName());

                    output
                            .append(isValid ?
                                    String.format("Successfully imported town %s - %d",
                                            townSeedDto.getTownName(),
                                            townSeedDto.getPopulation()) :
                                    "Invalid town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(this.townRepository::save);


        return output.toString();
    }

    @Override
    public boolean doesEntityExist(String townName) {
        return this.townRepository.existsByTownName(townName);
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository.findByTownName(name).orElse(null);
    }
}
