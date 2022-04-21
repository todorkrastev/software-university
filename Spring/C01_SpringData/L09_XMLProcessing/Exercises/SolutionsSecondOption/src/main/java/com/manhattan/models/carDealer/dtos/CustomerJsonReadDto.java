package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerJsonReadDto {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name="birth-date")
    private String birthDate;

    @XmlElement(name="is-young-driver")
    private Boolean isYoungDriver;

    @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @NonNull
    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
