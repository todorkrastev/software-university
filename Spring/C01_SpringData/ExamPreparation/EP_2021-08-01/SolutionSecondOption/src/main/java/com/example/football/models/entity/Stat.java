package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="stats")
public class Stat extends BaseEntity{
    @Column(nullable = false)
    private float shooting; // a floating point number. The value must be positive (larger than 0).

    @Column(nullable = false)
    private float passing; // a floating point number. The value must be positive (larger than 0).

    @Column(nullable = false)
    private float endurance; // a floating point number. The value must be positive (larger than 0).

    public Stat() {
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
