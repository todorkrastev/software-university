package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsByMakeRootDto {

    @XmlElement(name="car")
    private List<CarsByMakeDto> cars;

    public CarsByMakeRootDto(List<CarsByMakeDto> cars) {
        this.cars = cars;
    }

    public CarsByMakeRootDto() {
    }
}
