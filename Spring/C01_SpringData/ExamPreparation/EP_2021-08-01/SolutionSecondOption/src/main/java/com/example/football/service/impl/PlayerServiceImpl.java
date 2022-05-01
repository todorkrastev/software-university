package com.example.football.service.impl;

import com.example.football.models.dto.BestPlayerDto;
import com.example.football.models.dto.PlayerSeedDto;
import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.*;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {
    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
    private final PlayerRepository repository;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public PlayerServiceImpl(PlayerRepository repository,
                             TownService townService, TeamService teamService, StatService statService, FileService fileService,
                             ValidationUtil validator,
                             ModelMapper mapper,
                             MessageService messageService) {
        this.repository = repository;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
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
    public String readPlayersFileContent() throws IOException {
        return this.fileService.readString(PLAYERS_FILE_PATH);
    }

    @Override
    public String importPlayers() throws JAXBException, IOException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
                this.fileService.readXmlFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class)
                        .getPlayers()
                        .stream()
                        .peek(playerSeedDto -> {
                            if (exists(playerSeedDto)) {
                                response.append("Invalid Stat");
                            }
                        })
                        .filter(playerDto -> !exists(playerDto))
                        .peek(playerDto -> messageService
                                .addMessage(response, playerDto, String.format("%s - %s - %s", playerDto.getFirstName(),
                                        playerDto.getLastName(), playerDto.getPosition())))
                        .filter(this.validator::isValid)
                        .map(playerSeedDto -> {
                            Player player = this.mapper.map(playerSeedDto, Player.class);
                            player.setTown(this.townService.getTownByName(player.getTown().getName()).orElse(null));
                            player.setTeam(this.teamService.getTeamByName(player.getTeam().getName()).orElse(null));
                            player.setStat(this.statService.getStatById(player.getStat().getId()).orElse(null));
                            return player;
                        })
                        .collect(Collectors.toList()));
        return response.toString().trim();
    }

    private boolean exists(PlayerSeedDto playerDto) {
        return this.repository.existsByEmail(playerDto.getEmail());
    }

    @Override
    public String exportBestPlayers() {

        return this.repository.findBestPlayersBornBetween(LocalDate.of(1995,01,01), LocalDate.of(2003,01,01))
                .stream()
                .map(BestPlayerDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
