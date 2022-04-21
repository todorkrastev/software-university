package com.manhattan.models.carDealer.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarAndPartsRootDto {

    @XmlElement(name = "car")
    private List<CarAndPartsDto> cars;

    public CarAndPartsRootDto(List<CarAndPartsDto> cars) {
        this.cars = cars;
    }

    public CarAndPartsRootDto() {
    }
}
