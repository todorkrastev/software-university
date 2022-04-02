package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final ModelMapper modelMapper;

    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ValidationUtil validationUtil, TownService townService, ModelMapper modelMapper) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstant.AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder output = new StringBuilder();

        AgentSeedDto[] fromJson = this.gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class);

        Arrays
                .stream(fromJson)
                .filter(agentSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(agentSeedDto) &&
                            !doesFirstNameExist(agentSeedDto.getFirstName()) &&
                            !doesEmailExist(agentSeedDto.getEmail()) &&
                            this.townService.doesEntityExist(agentSeedDto.getTown());

                    output
                            .append(isValid ?
                                    String.format("Successfully imported agent - %s %s",
                                            agentSeedDto.getFirstName(),
                                            agentSeedDto.getLastName()) :
                                    "Invalid agent")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(agentSeedDto -> {
                    Agent agent = this.modelMapper.map(agentSeedDto, Agent.class);

                    String townName = agentSeedDto.getTown();
                    Town town = this.townService.findByName(townName);
                    agent.setTown(town);

                    return agent;
                })
                .forEach(this.agentRepository::save);


        return output.toString();
    }

    private boolean doesEmailExist(String email) {
        return this.agentRepository.existsByEmail(email);
    }

    @Override
    public boolean doesFirstNameExist(String firstName) {
        return this.agentRepository.existsByFirstName(firstName);
    }

    @Override
    public Agent findByName(String name) {
        return this.agentRepository.findByFirstName(name).orElse(null);
    }
}
