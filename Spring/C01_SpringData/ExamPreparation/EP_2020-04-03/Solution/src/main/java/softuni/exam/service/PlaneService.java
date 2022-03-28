package softuni.exam.service;

import softuni.exam.models.entity.Plane;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface PlaneService {

    boolean areImported();

    String readPlanesFileContent() throws IOException;

    String importPlanes() throws JAXBException, FileNotFoundException;

    boolean doesEntityExist(String registerNumber);

    Plane findByRegisterNumber(String registerNumber);
}
