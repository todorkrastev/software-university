package softuni.exam.service;

import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

public interface TeamService {

    String importTeams() throws JAXBException, IOException;

    boolean areImported();

    String readTeamsXmlFile() throws IOException;

    Optional<Team> getTeamByNameAndPicture(String name, Picture picture);
}
