package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerBySalaryListDto;
import softuni.exam.domain.dtos.PlayerByTeamListDto;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.PlayerService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/json/players.json";
    private final PlayerRepository repository;
    private final PictureService pictureService;
    private final TeamService teamService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public PlayerServiceImpl(PlayerRepository repository,
                             PictureService pictureService,
                             TeamService teamService,
                             FileService fileService,
                             ValidationUtil validator,
                             ModelMapper mapper,
                             MessageService messageService) {
        this.repository = repository;
        this.pictureService = pictureService;
        this.teamService = teamService;
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
    public String readPlayersJsonFile() throws IOException {
        return fileService.readString(PLAYERS_FILE_PATH);
    }

    @Override
    public String importPlayers() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(PLAYERS_FILE_PATH, PlayerSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PlayerSeedDto player) {
        Optional<Picture> picture = pictureService.getByUrl(player.getPicture().getUrl());
        Optional<Picture> teamPicture = pictureService.getByUrl(player.getTeam().getPicture().getUrl());
        Optional<Team> team = teamService.getTeamByNameAndPicture(player.getTeam().getName(), teamPicture.get());
        boolean isValid = this.validator.isValid(player) && picture.isPresent() && team.isPresent();
        String message = this.messageService.getMessage(player, isValid);

        if (isValid) {
            Player dbPlayer = this.mapper.map(player, Player.class);
            dbPlayer.setPicture(picture.get());
            dbPlayer.setTeam(team.get());
            this.repository.save(dbPlayer);
        }

        return message;
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        return repository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
                .stream()
                .map(p -> mapper.map(p, PlayerBySalaryListDto.class))
                .map(PlayerBySalaryListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportPlayersInATeam() {
        return String.format("Team: North Hub%n%s",
                repository.findAllByTeamNameOrderByIdAsc("North Hub")
                        .stream()
                        .map(p -> mapper.map(p, PlayerByTeamListDto.class))
                        .map(PlayerByTeamListDto::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
