package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;

import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CarJsonReadDto {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private long travelledDistance;

    @Size(min=1)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Size(min=1)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Min(0)
    @Max(Long.MAX_VALUE)
    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
