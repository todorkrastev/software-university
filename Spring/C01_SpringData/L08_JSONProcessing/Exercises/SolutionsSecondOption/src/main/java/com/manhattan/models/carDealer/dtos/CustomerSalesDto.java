package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;

public class CustomerSalesDto {
    @Expose
    private String fullName;

    @Expose
    private long boughtCars;

    @Expose
    @JsonAdapter(SpentMoneyAdapter.class)
    private double spentMoney;

    public CustomerSalesDto(String fullName, Long boughtCars, double spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(long boughtCars) {
        this.boughtCars = boughtCars;
    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(double spentMoney) {
        this.spentMoney = spentMoney;
    }
}
