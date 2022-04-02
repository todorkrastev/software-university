package softuni.exam.service;


import softuni.exam.models.entity.Agent;

import java.io.IOException;

public interface AgentService {

    boolean areImported();

    String readAgentsFromFile() throws IOException;
	
	String importAgents() throws IOException;

    boolean doesFirstNameExist(String firstName);

    Agent findByName(String name);
}
