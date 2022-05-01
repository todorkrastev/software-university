package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.FileService;
import com.example.football.service.MessageService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    public static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";
    private final TeamRepository repository;
    private final TownService townService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public TeamServiceImpl(TeamRepository repository,
                           TownService townService, FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper,
                           MessageService messageService) {
        this.repository = repository;
        this.townService = townService;
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
    public String readTeamsFileContent() throws IOException {
        return this.fileService.readString(TEAMS_FILE_PATH);
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
        Arrays.stream(this.fileService.readJsonFile(TEAMS_FILE_PATH, TeamSeedDto[].class))
                .peek(teamSeedDto -> {
                    if (exists(teamSeedDto)) {
                        response.append("Invalid Stat");
                    }
                })
                .filter(teamSeedDto -> !exists(teamSeedDto))
                .peek(team -> messageService
                        .addMessage(response, team, String.format("%s - %d", team.getName(), team.getFanBase())))
                .filter(this.validator::isValid)
                .map(team -> {
                    Team dbTeam = this.mapper.map(team, Team.class);
                    dbTeam.setTown(townService.getTownByName(team.getTownName()).orElse(null));
                    return dbTeam;
                })
                .collect(Collectors.toList()));
        return response.toString().trim();
    }

    private boolean exists(TeamSeedDto teamSeedDto) {
        return this.getTeamByName(teamSeedDto.getName()).isPresent();
    }

    @Override
    public Optional<Team> getTeamByName(String name) {
        return this.repository.findOneByName(name);
    }
}
