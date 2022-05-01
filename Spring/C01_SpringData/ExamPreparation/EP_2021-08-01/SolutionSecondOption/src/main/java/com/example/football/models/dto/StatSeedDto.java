package com.example.football.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedDto {
    @XmlElement(name="shooting")
    private float shooting; // a floating point number. The value must be positive (larger than 0).

    @XmlElement(name="passing")
    private float passing; // a floating point number. The value must be positive (larger than 0).

    @XmlElement(name="endurance")
    private float endurance; // a floating point number. The value must be positive (larger than 0).

    public StatSeedDto() {
    }

    @Positive
    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    @Positive
    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    @Positive
    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
