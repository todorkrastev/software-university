package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.SellerSeedRootDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstant.SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        SellerSeedRootDto sellerSeedRootDto = this.xmlParser.fromFile(GlobalConstant.SELLERS_FILE_PATH, SellerSeedRootDto.class);

        sellerSeedRootDto
                .getSellers()
                .stream()
                .filter(sellerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(sellerSeedDto);

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully import seller %s - %s",
                                            sellerSeedDto.getLastName(), sellerSeedDto.getEmail())
                                    : "Invalid seller")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
                .forEach(this.sellerRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public Seller findById(Long id) {
        return this.sellerRepository
                .findById(id)
                .orElse(null);
    }
}
