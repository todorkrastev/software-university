package exam.service.impl;

import exam.model.dto.LaptopListDto;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.util.FileService;
import exam.service.LaptopService;
import exam.util.MessageService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {
    public static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;
    private final ShopService shopService;


    public LaptopServiceImpl(LaptopRepository repository,
                             FileService fileService,
                             ValidationUtil validator,
                             MessageService messageService,
                             ModelMapper mapper,
                             ShopService shopService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return this.fileService.readString(LAPTOPS_FILE_PATH);
    }

    @Override
    public String importLaptops() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(LAPTOPS_FILE_PATH, LaptopSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(LaptopSeedDto laptop) {
        boolean isValid = this.validator.isValid(laptop, this::isUnique);
        String message = this.messageService.getMessage(laptop, isValid);

        if (isValid) {
            Laptop dbLaptop = this.mapper.map(laptop, Laptop.class);
            Shop shop = shopService.getByName(laptop.getShop().getName());
            dbLaptop.setShop(shop);
            this.repository.save(dbLaptop);
        }

        return message;
    }

    @Override
    public String exportBestLaptops() {
        return repository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc()
                .stream()
                .map(l -> this.mapper.map(l, LaptopListDto.class))
                .map(LaptopListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private boolean isUnique(LaptopSeedDto s) {
        return !repository.existsByMacAddress(s.getMacAddress());
    }
}
