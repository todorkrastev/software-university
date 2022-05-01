package exam.service.impl;

import exam.model.dto.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.util.FileService;
import exam.util.MessageService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    public static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;
    private final TownService townService;

    public CustomerServiceImpl(CustomerRepository repository,
                               FileService fileService,
                               ValidationUtil validator,
                               MessageService messageService,
                               ModelMapper mapper,
                               TownService townService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return this.fileService.readString(CUSTOMERS_FILE_PATH);
    }

    @Override
    public String importCustomers() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(CUSTOMERS_FILE_PATH, CustomerSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(CustomerSeedDto customer) {
        boolean isValid = this.validator.isValid(customer, this::isUnique);
        String message = this.messageService.getMessage(customer, isValid);

        if (isValid){
            Customer dbCustomer = this.mapper.map(customer, Customer.class);
            dbCustomer.setTown(townService.getTownByName(customer.getTown().getName()));
            this.repository.save(dbCustomer);
        }

        return message;
    }

    private boolean isUnique(CustomerSeedDto c) {
        return !repository.existsByEmail(c.getEmail());
    }
}
