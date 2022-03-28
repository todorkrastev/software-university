package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface TicketService {

    boolean areImported();

    String readTicketsFileContent() throws IOException;
	
	String importTickets() throws JAXBException, FileNotFoundException;

}
