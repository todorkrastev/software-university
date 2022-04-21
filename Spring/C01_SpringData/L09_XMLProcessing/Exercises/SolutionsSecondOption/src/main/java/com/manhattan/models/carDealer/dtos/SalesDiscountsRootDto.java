package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDiscountsRootDto {

    @XmlElement(name="sale")
    private List<SalesDiscountsDto> sales;

    public SalesDiscountsRootDto(List<SalesDiscountsDto> sales) {
        this.sales = sales;
    }

    public SalesDiscountsRootDto() {
    }
}
