package com.manhattan.models.carDealer.dtos;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class CarAndPartsDto {
    @Expose
    CarsByMakeDto car;

    @Expose
    List<PartForCarDto> parts;

    public CarAndPartsDto() {
        parts = new ArrayList<>();
    }

    public CarsByMakeDto getCar() {
        return car;
    }

    public void setCar(CarsByMakeDto car) {
        this.car = car;
    }

    public List<PartForCarDto> getParts() {
        return parts;
    }

    public void setParts(List<PartForCarDto> parts) {
        this.parts = parts;
    }
}
