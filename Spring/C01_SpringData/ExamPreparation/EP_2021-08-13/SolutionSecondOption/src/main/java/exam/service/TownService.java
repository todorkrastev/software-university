package exam.service;
import exam.model.entity.Town;
import exam.repository.TownRepository;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws JAXBException, IOException;

    Town getTownByName(String name);
}
