package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferSeedDto;
import softuni.exam.models.dtos.OfferSeedRootDto;
import softuni.exam.models.entities.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.FileService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    public static final String OFFERS_SEED_FILE = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository repository;
    private final CarServiceImpl carService;
    private final SellerService sellerService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public OfferServiceImpl(OfferRepository repository,
                            CarServiceImpl carService,
                            SellerService sellerService,
                            FileService fileService,
                            ValidationUtil validator,
                            ModelMapper mapper) {
        this.repository = repository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return this.fileService.readString(OFFERS_SEED_FILE);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder response = new StringBuilder();

        this.repository.saveAll(
                this.fileService.readXmlFile(OFFERS_SEED_FILE, OfferSeedRootDto.class)
                        .getOffers()
                        .stream()
                        .map(offer -> appendResponseMessage(response, offer))
                        .filter(this.validator::isValid)
                        .map(o -> {
                            Offer offer = this.mapper.map(o, Offer.class);
                            offer.setCar(carService.getCar(o.getCar().getId()).orElse(null));
                            offer.setSeller(sellerService.getSeller(o.getSeller().getId()).orElse(null));
                            return offer;
                        })
                        .collect(Collectors.toList()));
        return response.toString().trim();
    }

    private OfferSeedDto appendResponseMessage(StringBuilder response, OfferSeedDto offer) {
        String message;
        if (this.validator.isValid(offer)) {
            message = String.format("Successfully import offer %s - %s",
                    this.mapper.map(offer.getAddedOn(), LocalDateTime.class), offer.getHasGoldStatus());
        } else {
            message = "Invalid offer";
        }
        response.append(message).append(System.lineSeparator());
        return offer;
    }
}
