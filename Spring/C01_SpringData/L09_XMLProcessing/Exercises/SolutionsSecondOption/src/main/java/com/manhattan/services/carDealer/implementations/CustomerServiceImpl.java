package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.dtos.CustomerSalesRootDto;
import com.manhattan.models.carDealer.dtos.OrderedCustomersDto;
import com.manhattan.models.carDealer.dtos.OrderedCustomersRootDto;
import com.manhattan.models.carDealer.entities.Customer;
import com.manhattan.repositories.carDealer.CustomerRepository;
import com.manhattan.services.carDealer.interfaces.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(Iterable<Customer> customers) {
        this.repository.saveAllAndFlush(customers);
    }

    @Override
    public Customer getRandomCustomer() {
        return this.repository.getById(
                ThreadLocalRandom.current().nextLong(1L, this.repository.count() + 1));
    }

    @Override
    public OrderedCustomersRootDto getCustomersOrderedByBirthDateAndYoungerDrivers() {
        return new OrderedCustomersRootDto(
                this.repository.findAllByOrderByBirthDateAscYoungerDriverAsc()
                        .stream()
                        .map(c -> mapper.map(c, OrderedCustomersDto.class))
                        .collect(Collectors.toList()));
    }

    @Override
    public CustomerSalesRootDto getAllCustomersWithTotalOfTheSales() {
        return new CustomerSalesRootDto(this.repository.findAllCustomersWithThereSales());
    }

    @Override
    public boolean hasNoRecords() {
        return this.repository.count() == 0;
    }
}
