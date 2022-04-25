package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductSoldDto {
    @Expose
    private int count;

    @Expose
    private List<ProductDetailsDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductDetailsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailsDto> products) {
        this.products = products;
        //this.count = products.size();
    }
}
