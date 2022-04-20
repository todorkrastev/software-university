package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.CustomerSalesDto;
import com.manhattan.models.carDealer.dtos.OrderedCustomersDto;
import com.manhattan.models.carDealer.entities.Customer;

import java.util.List;

public interface CustomerService {
    void saveAll(Iterable<Customer> customers);
    Customer getRandomCustomer();
    List<OrderedCustomersDto> getCustomersOrderedByBirthDateAndYoungerDrivers();

    List<CustomerSalesDto> getAllCustomersWithTotalOfTheSales();
}
