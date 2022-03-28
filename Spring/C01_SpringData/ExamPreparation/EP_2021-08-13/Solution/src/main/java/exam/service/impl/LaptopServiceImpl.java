package exam.service.impl;

import com.google.gson.Gson;
import exam.constant.GlobalConstant;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final ShopService shopService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopService shopService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.laptopRepository = laptopRepository;
        this.shopService = shopService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        LaptopSeedDto[] dtos = this.gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);

        Arrays
                .stream(dtos)
                .filter(laptopSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(laptopSeedDto) &&
                            !doesEntityExist(laptopSeedDto.getMacAddress()) &&
                            this.shopService.doesEntityExist(laptopSeedDto.getShop().getName());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                            laptopSeedDto.getMacAddress(),
                                            laptopSeedDto.getCpuSpeed(),
                                            laptopSeedDto.getRam(),
                                            laptopSeedDto.getStorage()) :
                                    "Invalid Laptop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = this.modelMapper.map(laptopSeedDto, Laptop.class);

                    String shopName = laptopSeedDto.getShop().getName();
                    Shop shop = this.shopService.findByName(shopName);
                    laptop.setShop(shop);

                    return laptop;
                })
                .forEach(this.laptopRepository::save);

        return stringBuilder.toString();
    }

    private boolean doesEntityExist(String macAddress) {
        return this.laptopRepository.existsByMacAddress(macAddress);
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Laptop> bestLaptops = this.laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();

        bestLaptops
                .forEach(laptop -> stringBuilder
                        .append(String.format("""
                                        Laptop - %s
                                        *Cpu speed - %.2f
                                        **Ram - %d
                                        ***Storage - %d
                                        ****Price - %s
                                        #Shop name - %s
                                        ##Town - %s
                                        """,
                                laptop.getMacAddress(),
                                laptop.getCpuSpeed(),
                                laptop.getRam(),
                                laptop.getStorage(),
                                laptop.getPrice().toString(),
                                laptop.getShop().getName(),
                                laptop.getShop().getTown().getName()))
                        .append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}
