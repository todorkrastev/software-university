package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.dtos.CarJsonReadDto;
import com.manhattan.models.carDealer.dtos.CustomerJsonReadDto;
import com.manhattan.models.carDealer.dtos.PartsJsonReadDto;
import com.manhattan.models.carDealer.dtos.SuppliersJsonReadDto;
import com.manhattan.models.carDealer.entities.*;
import com.manhattan.services.carDealer.interfaces.*;
import com.manhattan.services.common.FileService;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.manhattan.utils.CommonConstants.*;

@Service
public class SeedCarDealerServiceImpl implements SeedCarDealerService {
    private final SupplierService supplierService;
    private final PartsService partsService;
    private final CarService carService;
    private final CustomerService customerService;

    private final ValidationsUtil validator;
    private final FileService fileService;
    private final ModelMapper modelMapper;
    private final SaleService salesService;

    public SeedCarDealerServiceImpl(SupplierService supplierService,
                                    PartsService partsService, CarService carService, CustomerService customerService, ValidationsUtil validator,
                                    FileService fileService,
                                    ModelMapper modelMapper, SaleService salesService) {
        this.supplierService = supplierService;
        this.partsService = partsService;
        this.carService = carService;
        this.customerService = customerService;
        this.validator = validator;
        this.fileService = fileService;
        this.modelMapper = modelMapper;
        this.salesService = salesService;
    }

    @Override
    public void seed() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

    private void seedSales() {
        List<Sale> sales = new ArrayList<>();
        IntStream.range(1,100)
                .forEach(i-> sales.add(new Sale(carService.getRandomCar(),customerService.getRandomCustomer(),
                        getRandomDiscount())));
        this.salesService.saveAll(sales);
    }

    private BigDecimal getRandomDiscount() {
        BigDecimal[] discounts = {
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(5),
                BigDecimal.valueOf(10),
                BigDecimal.valueOf(15),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(30),
                BigDecimal.valueOf(40),
                BigDecimal.valueOf(50),
        };
        return discounts[ThreadLocalRandom.current().nextInt(0, discounts.length)];
    }

    private void seedCustomers() throws IOException {
        this.customerService.saveAll(
                Arrays.stream(fileService
                                .readJSONFile(RESOURCE_FILE_PATH + CUSTOMERS_FILE, CustomerJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(cust -> modelMapper.map(cust, Customer.class))
                        .collect(Collectors.toList())
        );
    }

    private void seedCars() throws IOException {
        List<Car> collect = Arrays.stream(fileService
                        .readJSONFile(RESOURCE_FILE_PATH + CARS_FILE, CarJsonReadDto[].class))
                .filter(validator::isValid)
                .map(car -> modelMapper.map(car, Car.class))
                .map(car -> {
                    car.setParts(partsService.getRandomParts());
                    return car;
                })
                .collect(Collectors.toList());
        this.carService.saveAll(
                collect
        );
    }

    private void seedParts() throws IOException {
        this.partsService.saveAll(
                Arrays.stream(fileService
                                .readJSONFile(RESOURCE_FILE_PATH + PARTS_FILE, PartsJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(part -> modelMapper.map(part, Part.class))
                        .map(part -> {
                            part.setSupplier(supplierService.getRandomSupplier());
                            return part;
                        })
                        .collect(Collectors.toList())
        );
    }

    private void seedSuppliers() throws IOException {
        this.supplierService.saveAll(
                Arrays.stream(fileService
                                .readJSONFile(RESOURCE_FILE_PATH + SUPPLIERS_FILE, SuppliersJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(supp -> modelMapper.map(supp, Supplier.class))
                        .collect(Collectors.toList())
        );
    }
}
