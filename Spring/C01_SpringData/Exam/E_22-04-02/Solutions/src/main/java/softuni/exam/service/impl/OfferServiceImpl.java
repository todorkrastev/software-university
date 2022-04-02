package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.BestOfferDto;
import softuni.exam.models.dto.OfferRootSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationUtil validationUtil, AgentService agentService, ApartmentService apartmentService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();

        OfferRootSeedDto fromFile = this.xmlParser.fromFile(GlobalConstant.OFFERS_FILE_PATH, OfferRootSeedDto.class);

        fromFile
                .getOffers()
                .stream()
                .filter(offerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(offerSeedDto) &&
                            this.agentService.doesFirstNameExist(offerSeedDto.getAgent().getName()) &&
                            this.apartmentService.existsById(offerSeedDto.getApartment().getId());

                    output
                            .append(isValid ?
                                    String.format("Successfully imported offer %.2f",
                                            offerSeedDto.getPrice().doubleValue()) :
                                    "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(offerSeedDto -> {
                    Offer offer = this.modelMapper.map(offerSeedDto, Offer.class);

                    String agentName = offerSeedDto.getAgent().getName();
                    Agent agent = this.agentService.findByName(agentName);
                    offer.setAgent(agent);

                    Long apartmentId = offerSeedDto.getApartment().getId();
                    Apartment apartment = this.apartmentService.findById(apartmentId);
                    offer.setApartment(apartment);

                    return offer;
                })
                .forEach(this.offerRepository::save);

        return output.toString();
    }

    @Override
    public String exportOffers() {
        List<BestOfferDto> bestOffersByGivenCriteria = this.offerRepository.findBestOffersByGivenCriteria();

        return bestOffersByGivenCriteria
                .stream()
                .map(BestOfferDto::toString)
                .collect(Collectors.joining());
    }
}
