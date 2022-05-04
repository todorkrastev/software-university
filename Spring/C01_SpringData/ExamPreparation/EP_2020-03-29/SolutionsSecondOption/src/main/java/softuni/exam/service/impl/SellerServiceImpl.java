package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerSeedDto;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.FileService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {
    public static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";
    private final SellerRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public SellerServiceImpl(SellerRepository repository, FileService fileService, ValidationUtil validator, ModelMapper mapper) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return this.fileService.readString(SELLERS_FILE_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
                this.fileService.readXmlFile(SELLERS_FILE_PATH, SellerSeedRootDto.class)
                        .getSellers()
                        .stream()
                        .map(seller -> appendResponseMessage(response, seller))
                        .filter(this.validator::isValid)
                        .map(s -> this.mapper.map(s, Seller.class))
                        .collect(Collectors.toList())
        );
        return response.toString().trim();
    }

    @Override
    public Optional<Seller> getSeller(long id) {
        return this.repository.findById(id);
    }

    private SellerSeedDto appendResponseMessage(StringBuilder response, SellerSeedDto seller) {
        String message;
        if (this.validator.isValid(seller)) {
            message = String.format("Successfully import seller %s - %s", seller.getLastName(), seller.getEmail());
        } else {
            message = "Invalid seller";
        }
        response.append(message).append(System.lineSeparator());
        return seller;
    }
}
