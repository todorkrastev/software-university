package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.manhattan.models.carDealer.entities.Sale;

import java.time.LocalDate;

public class OrderedCustomersDto {
    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("BirthDate")
    private String birthDate;

    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;

    @Expose
    @SerializedName("Sales")
    private Sale[] sales;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Sale[] getSales() {
        return sales;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }
}
