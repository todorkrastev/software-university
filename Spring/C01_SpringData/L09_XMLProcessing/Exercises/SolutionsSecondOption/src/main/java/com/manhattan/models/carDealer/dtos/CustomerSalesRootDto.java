package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesRootDto {

    @XmlElement(name="customer")
    private List<CustomerSalesDto> customers;

    public CustomerSalesRootDto(List<CustomerSalesDto> customers) {
        this.customers = customers;
    }

    public CustomerSalesRootDto() {
    }
}
