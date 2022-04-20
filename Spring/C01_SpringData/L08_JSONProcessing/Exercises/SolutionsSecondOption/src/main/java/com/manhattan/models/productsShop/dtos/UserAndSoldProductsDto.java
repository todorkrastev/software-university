package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

public class UserAndSoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private ProductSoldDto soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
