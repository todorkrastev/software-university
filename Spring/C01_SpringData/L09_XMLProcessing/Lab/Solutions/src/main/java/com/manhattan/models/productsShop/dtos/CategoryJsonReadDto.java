package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class CategoryJsonReadDto {
    @Expose
    private String name;

    @Size(min=3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
