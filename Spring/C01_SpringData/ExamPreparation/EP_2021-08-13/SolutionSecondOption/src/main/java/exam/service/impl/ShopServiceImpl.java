package exam.service.impl;

import exam.model.dto.ShopSeedDto;
import exam.model.dto.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.util.FileService;
import exam.util.MessageService;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {
    public static final String SHOP_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           ModelMapper mapper,
                           MessageService messageService,
                           TownService townService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return this.fileService.readString(SHOP_FILE_PATH);
    }

    @Override
    public String importShops() throws JAXBException, IOException {
        return this.fileService.readXmlFile(SHOP_FILE_PATH, ShopSeedRootDto.class)
                .getShops()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Shop getByName(String name) {
        return repository.findByName(name);
    }

    private String persistIfValid(ShopSeedDto shop) {
        boolean isValid = this.validator.isValid(shop, this::isUnique);
        String message = this.messageService.getMessage(shop, isValid);
        if (isValid){
            Shop dbShop = this.mapper.map(shop, Shop.class);
            dbShop.setTown(townService.getTownByName(shop.getTown().getName()));
            this.repository.save(dbShop);
        }
        return message;
    }

    private boolean isUnique(ShopSeedDto s) {
        return !repository.existsByName(s.getName());
    }
}
