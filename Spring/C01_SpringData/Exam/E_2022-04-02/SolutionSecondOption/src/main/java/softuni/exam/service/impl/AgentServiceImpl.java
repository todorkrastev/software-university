package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {
    public static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";
    private final AgentRepository repository;
    private final TownService townService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;

    @Autowired
    public AgentServiceImpl(AgentRepository repository,
                            TownService townService,
                            FileService fileService,
                            ValidationUtil validator,
                            MessageService messageService,
                            ModelMapper mapper) {
        this.repository = repository;
        this.townService = townService;
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
    public String readAgentsFromFile() throws IOException {
        return this.fileService.readString(AGENTS_FILE_PATH);
    }

    @Override
    public String importAgents() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(AGENTS_FILE_PATH, AgentSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Agent> getByName(String firstName) {
        return repository.findOneByFirstName(firstName);
    }

    private String persistIfValid(AgentSeedDto agent) {
        Optional<Town> town = townService.getByTownName(agent.getTown());
        boolean isValid = this.validator.isValid(agent, this::isUnique) && town.isPresent();
        String message = this.messageService.getMessage(agent, isValid);

        if (isValid) {
            Agent dbAgent = mapper.map(agent, Agent.class);
            dbAgent.setTown(town.get());
            this.repository.save(dbAgent);
        }

        return message;
    }

    private boolean isUnique(AgentSeedDto agent) {
        return !repository.existsAgentByFirstNameOrEmail(agent.getFirstName(), agent.getEmail());
    }
}
