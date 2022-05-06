package hiberspring.service.impl;

import hiberspring.domain.dtos.TownSeedDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileService;
import hiberspring.util.MessageService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    public static final String TOWNS_FILE_PATH = "src/main/resources/files/towns.json";
    private final TownRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;


    public TownServiceImpl(TownRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper,
                           MessageService messageService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public Boolean townsAreImported() {
        return repository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileService.readString(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(TOWNS_FILE_PATH, TownSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Town> getTownByName(String name) {
        return repository.findOneByName(name);
    }

    private String persistIfValid(TownSeedDto town) {
        boolean isValid = this.validator.isValid(town, this::isUnique);
        String message = this.messageService.getMessage(town, isValid);

        if (isValid) {
           this.repository.save(mapper.map(town, Town.class));
        }

        return message;
    }

    private boolean isUnique(TownSeedDto e) {
        return !repository.existsByName(e.getName());
    }
}
