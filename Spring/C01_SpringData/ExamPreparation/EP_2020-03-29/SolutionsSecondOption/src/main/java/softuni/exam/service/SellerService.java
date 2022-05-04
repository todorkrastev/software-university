package softuni.exam.service;

import softuni.exam.models.entities.Seller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

public interface SellerService {
    
    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException, JAXBException;

    Optional<Seller> getSeller(long id);
}
