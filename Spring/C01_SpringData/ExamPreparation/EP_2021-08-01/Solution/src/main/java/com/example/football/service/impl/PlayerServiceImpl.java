package com.example.football.service.impl;

import com.example.football.constant.GlobalConstant;
import com.example.football.models.dto.BestPlayerDto;
import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final StatService statService;
    private final TeamService teamService;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository, StatService statService, TeamService teamService, TownService townService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.statService = statService;
        this.teamService = teamService;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto = this.xmlParser.fromFile(GlobalConstant.PLAYERS_FILE_PATH, PlayerSeedRootDto.class);


        playerSeedRootDto
                .getPlayers()
                .stream()
                .filter(playerDetailsDto -> {
                    boolean isValid = this.validationUtil.isValid(playerDetailsDto) &&
                            !doesEntityExist(playerDetailsDto.getEmail()) &&
                            this.teamService.doesEntityExist(playerDetailsDto.getTeam().getName()) &&
                            this.townService.doesEntityExist(playerDetailsDto.getTown().getName()) &&
                            this.statService.doesEntityIdExist(playerDetailsDto.getStat().getId());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Player %s %s - %s",
                                            playerDetailsDto.getFirstName(),
                                            playerDetailsDto.getLastName(),
                                            playerDetailsDto.getPosition().name()) :
                                    "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerDetailsDto -> {
                    Player player = this.modelMapper.map(playerDetailsDto, Player.class);

                    Long statId = playerDetailsDto.getStat().getId();
                    Stat stat = this.statService.findById(statId);
                    player.setStat(stat);

                    String teamName = playerDetailsDto.getTeam().getName();
                    Team team = this.teamService.findByName(teamName);
                    player.setTeam(team);

                    String townName = playerDetailsDto.getTown().getName();
                    Town town = this.townService.findByName(townName);
                    player.setTown(town);

                    return player;
                })
                .forEach(this.playerRepository::save);

        return stringBuilder.toString();
    }

    private boolean doesEntityExist(String email) {
        return this.playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {
        LocalDate after = LocalDate.of(2003, 1, 1);
        LocalDate before = LocalDate.of(1995, 1, 1);

        List<BestPlayerDto> bestPlayersDetails = this.playerRepository.findBestPlayersBornBetween(before, after);

        return bestPlayersDetails
                .stream()
                .map(BestPlayerDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
