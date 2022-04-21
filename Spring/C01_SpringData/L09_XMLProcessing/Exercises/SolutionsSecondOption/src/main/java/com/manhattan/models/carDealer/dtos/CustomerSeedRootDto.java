package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSeedRootDto {

    @XmlElement(name="customer")
    private Set<CustomerJsonReadDto> customers;

    public CustomerSeedRootDto() {
        this.customers = new HashSet<>();
    }

    public Set<CustomerJsonReadDto> getCustomers() {
        return customers;
    }
}
