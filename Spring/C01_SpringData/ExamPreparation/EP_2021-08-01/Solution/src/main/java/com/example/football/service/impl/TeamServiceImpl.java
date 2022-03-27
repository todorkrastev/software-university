package com.example.football.service.impl;

import com.example.football.constant.GlobalConstant;
import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownService townService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TeamServiceImpl(TeamRepository teamRepository, TownService townService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.townService = townService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        TeamSeedDto[] teamSeedDtos = this.gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class);


        Arrays
                .stream(teamSeedDtos)
                .filter(teamSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(teamSeedDto)
                            && !doesEntityExist(teamSeedDto.getName()) &&
                            this.townService.doesEntityExist(teamSeedDto.getTownName());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Team %s - %d",
                                            teamSeedDto.getName(), teamSeedDto.getFanBase()) :
                                    "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = this.modelMapper.map(teamSeedDto, Team.class);

                    String townName = team.getTown().getName();
                    Town town = this.townService.findByName(townName);
                    team.setTown(town);

                    return team;
                })
                .forEach(this.teamRepository::save);


        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String name) {
        return this.teamRepository.existsByName(name);
    }

    @Override
    public Team findByName(String name) {
        return this.teamRepository.findByName(name).orElse(null);
    }
}
