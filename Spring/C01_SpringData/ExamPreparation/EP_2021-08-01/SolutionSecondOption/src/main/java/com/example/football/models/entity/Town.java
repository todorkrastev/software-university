package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="towns")
public class Town extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name ; //min len 2. The  values are unique in the database.

    @Column(nullable = false)
    private int population; // – accepts number values (must be a positive number), 0 as a value is exclusive.

    @Column(name = "travel_guide", nullable = false, columnDefinition = "TEXT")
    private String travelGuide; // length value higher than or equal to 10.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}
