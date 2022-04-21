package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomersRootDto {

    @XmlElement(name="customer")
    private List<OrderedCustomersDto> orders;

    public OrderedCustomersRootDto(List<OrderedCustomersDto> orders) {
        this.orders = orders;
    }

    public OrderedCustomersRootDto() {
    }
}
