package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository, CarService carService, SellerService sellerService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
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
        StringBuilder stringBuilder = new StringBuilder();

        OfferSeedRootDto offerSeedRootDto = this.xmlParser.fromFile(GlobalConstant.OFFERS_FILE_PATH, OfferSeedRootDto.class);

        System.out.println();

        offerSeedRootDto
                .getOffers()
                .stream()
                .filter(offerSeedDto -> {
                            boolean isValid = this.validationUtil.isValid(offerSeedDto);

                            stringBuilder
                                    .append(isValid ?
                                            String.format("Successfully import offer %s - %s",
                                                    offerSeedDto.getAddedOn(), offerSeedDto.getHasGoldStatus()) :
                                            "Invalid offer"
                                    )
                                    .append(System.lineSeparator());

                            return isValid;
                        }
                )
                .map(offerSeedDto -> {
                    Offer offer = this.modelMapper.map(offerSeedDto, Offer.class);

                    Long carId = offerSeedDto.getCar().getId();
                    Car car = this.carService.findById(carId);
                    offer.setCar(car);

                    Long sellerId = offerSeedDto.getSeller().getId();
                    Seller seller = this.sellerService.findById(sellerId);
                    offer.setSeller(seller);

                    return offer;
                })
                .forEach(this.offerRepository::save);

        return stringBuilder.toString();
    }
}
