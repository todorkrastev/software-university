package exam.service;



import exam.model.entity.Town;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws JAXBException, FileNotFoundException;

    boolean doesEntityExist(String name);

    Town findByName(String name);
}
