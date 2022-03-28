package exam.service.impl;

import exam.constant.GlobalConstant;
import exam.model.dto.ShopRootSeedDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    public ShopServiceImpl(ShopRepository shopRepository, TownService townService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        ShopRootSeedDto dtos = this.xmlParser.fromFile(GlobalConstant.SHOPS_FILE_PATH, ShopRootSeedDto.class);

        dtos
                .getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(shopSeedDto) &&
                            !doesEntityExist(shopSeedDto.getName()) &&
                            townService.doesEntityExist(shopSeedDto.getTown().getName());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Shop %s - %s",
                                            shopSeedDto.getName(),
                                            shopSeedDto.getIncome().toString()) :
                                    "Invalid shop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = this.modelMapper.map(shopSeedDto, Shop.class);

                    String townName = shopSeedDto.getTown().getName();
                    Town town = this.townService.findByName(townName);
                    shop.setTown(town);

                    return shop;
                })
                .forEach(this.shopRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String name) {
        return this.shopRepository.existsByName(name);
    }

    @Override
    public Shop findByName(String name) {
        return this.shopRepository.findByName(name).orElse(null);
    }
}
