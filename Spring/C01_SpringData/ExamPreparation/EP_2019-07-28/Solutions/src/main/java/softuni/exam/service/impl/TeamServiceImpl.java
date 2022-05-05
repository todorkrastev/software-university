package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedDto;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    public static final String TEAMS_FILE_PATH = "src/main/resources/files/xml/teams.xml";
    private final TeamRepository repository;
    private final PictureService pictureService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public TeamServiceImpl(TeamRepository repository,
                           PictureService pictureService,
                           FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper,
                           MessageService messageService) {
        this.repository = repository;
        this.pictureService = pictureService;
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
    public String readTeamsXmlFile() throws IOException {
        return this.fileService.readString(TEAMS_FILE_PATH);

    }

    @Override
    public Optional<Team> getTeamByNameAndPicture(String name, Picture picture) {
        return repository.findOneByNameAndPicture(name, picture);
    }

    @Override
    public String importTeams() throws JAXBException, IOException {
        return this.fileService.readXmlFile(TEAMS_FILE_PATH, TeamSeedRootDto.class)
                .getTeams()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(TeamSeedDto team) {
        Optional<Picture> picture = pictureService.getByUrl(team.getPicture().getUrl());
        boolean isValid = this.validator.isValid(team) && picture.isPresent();
        String message = this.messageService.getMessage(team, isValid);
        if (isValid) {
            Team dbTeam= this.mapper.map(team, Team.class);
            dbTeam.setPicture(picture.get());
            this.repository.save(dbTeam);
        }
        return message;
    }
}
