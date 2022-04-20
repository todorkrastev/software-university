package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerJsonReadDto {
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
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
