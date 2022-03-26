package com.example.football.service.impl;

import com.example.football.constant.GlobalConstant;
import com.example.football.models.dto.TownSeedDto;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository, Gson gson) {
        this.townRepository = townRepository;
        this.gson = gson;
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
        StringBuilder stringBuilder = new StringBuilder();

        TownSeedDto[] townSeedDtos = this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class);
        return null;
    }
}
