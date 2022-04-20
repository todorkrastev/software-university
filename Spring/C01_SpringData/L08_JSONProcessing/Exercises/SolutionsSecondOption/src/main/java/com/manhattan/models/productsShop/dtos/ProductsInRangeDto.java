package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductsInRangeDto {
    @Expose
    private String name;
    @Expose
    private String price;
    @Expose
    private String seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
