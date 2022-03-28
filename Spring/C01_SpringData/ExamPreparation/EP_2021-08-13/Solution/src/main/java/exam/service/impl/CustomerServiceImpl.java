package exam.service.impl;

import com.google.gson.Gson;
import exam.constant.GlobalConstant;
import exam.model.dto.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final TownService townService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, TownService townService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.townService = townService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        CustomerSeedDto[] dtos = this.gson.fromJson(readCustomersFileContent(), CustomerSeedDto[].class);


        Arrays
                .stream(dtos)
                .filter(customerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(customerSeedDto) &&
                            !doesEntityExist(customerSeedDto.getEmail()) &&
                            this.townService.doesEntityExist(customerSeedDto.getTown().getName());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Customer %s %s - %s",
                                            customerSeedDto.getFirstName(),
                                            customerSeedDto.getLastName(),
                                            customerSeedDto.getEmail()) :
                                    "Invalid Customer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(customerSeedDto -> {
                    Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);

                    String townName = customerSeedDto.getTown().getName();
                    Town town = this.townService.findByName(townName);

                    customer.setTown(town);

                    return customer;
                })
                .forEach(this.customerRepository::save);

        return stringBuilder.toString();
    }

    private boolean doesEntityExist(String email) {
        return this.customerRepository.existsByEmail(email);
    }
}
