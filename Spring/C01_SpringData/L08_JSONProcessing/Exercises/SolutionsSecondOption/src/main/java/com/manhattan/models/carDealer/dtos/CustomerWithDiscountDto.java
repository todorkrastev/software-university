package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CustomerWithDiscountDto {
    @Expose
    @SerializedName("customerName")
    private String name;

    @Expose
    @SerializedName("Discount")
    private BigDecimal discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;

    public CustomerWithDiscountDto(String name, BigDecimal discount, BigDecimal price) {
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = BigDecimal.ONE.subtract(discount.divide(new BigDecimal(100))).multiply(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
