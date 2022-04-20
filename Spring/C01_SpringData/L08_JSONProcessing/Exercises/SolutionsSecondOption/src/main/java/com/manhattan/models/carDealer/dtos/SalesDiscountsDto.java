package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SalesDiscountsDto {
    @Expose
    private CarSimpleDto car;
    @Expose
    private CustomerWithDiscountDto customer;

    public SalesDiscountsDto(String make, String model, Long travelledDistance,
                             String name, BigDecimal discount, BigDecimal price, boolean isYounger) {
        this.car = new CarSimpleDto(make, model, travelledDistance);
        this.customer = new CustomerWithDiscountDto(name,discount.add(isYounger ? new BigDecimal(5):BigDecimal.ZERO), price);
    }
}
