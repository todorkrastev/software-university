package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.FileService;
import com.example.football.service.MessageService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {
    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public TownServiceImpl(TownRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper, MessageService messageService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.fileService.readString(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
                Arrays.stream(this.fileService.readJsonFile(TOWNS_FILE_PATH, TownSeedDto[].class))
                        .peek(townSeedDto -> {
                            if (exists(townSeedDto)) {
                                response.append("Invalid Stat");
                            }
                        })
                        .filter(seedDto -> !exists(seedDto))
                        .peek(town -> messageService
                                .addMessage(response, town, String.format("%s - %d", town.getName(), town.getPopulation())))
                        .filter(this.validator::isValid)
                        .map(town -> this.mapper.map(town, Town.class))
                        .collect(Collectors.toList())
        );
        return response.toString().trim();
    }

    private boolean exists(TownSeedDto seedDto) {
        return this.repository.findOneByName(seedDto.getName()).isPresent();
    }

    @Override
    public Optional<Town> getTownByName(String townName) {
        return this.repository.findOneByName(townName);
    }
}
