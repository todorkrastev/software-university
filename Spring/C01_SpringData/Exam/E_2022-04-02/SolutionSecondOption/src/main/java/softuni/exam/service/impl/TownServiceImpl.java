package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           MessageService messageService,
                           ModelMapper mapper) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.fileService.readString(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(TOWNS_FILE_PATH, TownSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Town> getByTownName(String townName) {
        return repository.findOneByTownName(townName);
    }

    private String persistIfValid(TownSeedDto town) {
        boolean isValid = this.validator.isValid(town, this::isUnique);
        String message = this.messageService.getMessage(town, isValid);

        if (isValid) {
            this.repository.save(mapper.map(town, Town.class));
        }

        return message;
    }

    private boolean isUnique(TownSeedDto town) {
        return !repository.existsByTownName(town.getTownName());
    }
}
