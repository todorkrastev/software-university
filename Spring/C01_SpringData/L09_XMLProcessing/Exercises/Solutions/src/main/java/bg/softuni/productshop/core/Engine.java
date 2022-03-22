package bg.softuni.productshop.core;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Engine {
    void run() throws IOException, JAXBException;
}
