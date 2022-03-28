package exam.service.impl;

import exam.constant.GlobalConstant;
import exam.model.dto.TownRootSeedDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
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
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        TownRootSeedDto townRootSeedDtos = this.xmlParser.fromFile(GlobalConstant.TOWNS_FILE_PATH, TownRootSeedDto.class);

        townRootSeedDtos
                .getTowns()
                .stream()
                .filter(townDetailsDto -> {
                    boolean isValid = this.validationUtil.isValid(townDetailsDto);

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Town %s",
                                            townDetailsDto.getName()) :
                                    "Invalid town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townDetailsDto -> this.modelMapper.map(townDetailsDto, Town.class))
                .forEach(this.townRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String name) {
        return this.townRepository.existsByName(name);
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository.findByName(name).orElse(null);
    }
}
