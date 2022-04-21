package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDiscountsDto {

    @XmlElement(name="car")
    private CarSimpleDto car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement(name = "discount")
    private BigDecimal discount;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;


    public SalesDiscountsDto(String make, String model, Long travelledDistance,
                             String name, BigDecimal discount, BigDecimal price, boolean isYounger) {
        this.car = new CarSimpleDto(make, model, travelledDistance);
        this.customerName = name;
        this.discount = discount.divide(BigDecimal.valueOf(100));
        this.price = price;
        this.priceWithDiscount = BigDecimal.ONE.subtract(this.discount).multiply(price);
    }

    public SalesDiscountsDto() {
    }
}
