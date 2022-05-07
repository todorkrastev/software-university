package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferListDto;
import softuni.exam.models.dto.OfferSeedDto;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    public static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository repository;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;

    @Autowired
    public OfferServiceImpl(OfferRepository repository,
                            AgentService agentService,
                            ApartmentService apartmentService,
                            FileService fileService,
                            ValidationUtil validator,
                            MessageService messageService,
                            ModelMapper mapper) {
        this.repository = repository;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return this.fileService.readString(OFFERS_FILE_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        return this.fileService.readXmlFile(OFFERS_FILE_PATH, OfferSeedRootDto.class)
                .getOffers()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(OfferSeedDto offer) {
        Optional<Agent> agent = agentService.getByName(offer.getAgent().getName());
        Optional<Apartment> apartment = apartmentService.getById(offer.getApartment().getId());
        boolean isValid = this.validator.isValid(offer) && agent.isPresent() && apartment.isPresent();
        String message = this.messageService.getMessage(offer, isValid);
        if (isValid) {
            Offer dbOffer= this.mapper.map(offer, Offer.class);
            dbOffer.setAgent(agent.get());
            dbOffer.setApartment(apartment.get());
            this.repository.save(dbOffer);
        }
        return message;
    }

    @Override
    public String exportOffers() {
        return repository.findAllByApartmentApartmentTypeOrderByApartmentAreaDescPriceAsc(ApartmentType.three_rooms)
                .stream()
                .map(offer -> mapper.map(offer, OfferListDto.class))
                .map(OfferListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
