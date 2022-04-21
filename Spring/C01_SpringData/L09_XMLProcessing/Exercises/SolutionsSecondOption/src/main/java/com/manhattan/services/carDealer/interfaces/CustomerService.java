package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.CustomerSalesRootDto;
import com.manhattan.models.carDealer.dtos.OrderedCustomersRootDto;
import com.manhattan.models.carDealer.entities.Customer;

public interface CustomerService {
    void saveAll(Iterable<Customer> customers);
    Customer getRandomCustomer();
    OrderedCustomersRootDto getCustomersOrderedByBirthDateAndYoungerDrivers();

    CustomerSalesRootDto getAllCustomersWithTotalOfTheSales();

    boolean hasNoRecords();
}
