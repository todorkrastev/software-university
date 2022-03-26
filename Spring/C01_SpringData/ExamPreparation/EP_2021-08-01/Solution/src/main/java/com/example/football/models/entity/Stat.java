package com.example.football.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    private Float shooting;
    private Float passing;
    private Float endurance;

    public Stat() {
    }

    @Column(name = "shooting")
    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    @Column(name = "passing")
    public Float getPassing() {
        return passing;
    }

    public void setPassing(Float passing) {
        this.passing = passing;
    }

    @Column(name = "endurance")
    public Float getEndurance() {
        return endurance;
    }

    public void setEndurance(Float endurance) {
        this.endurance = endurance;
    }
}
