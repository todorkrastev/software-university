package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name; //character length higher than or equal to 3. The values are unique in the database.

    @Column(nullable = false, name="stadium_name")
    private String stadiumName; //– length value higher than or equal to 3.

    @Column(nullable = false, name = "fan_base")
    private int fanBase; //– accepts number values that are more than or equal to 1000.

    @Column(columnDefinition = "TEXT")
    private String history; //– a long and detailed description of team's history with a character length value higher
    // than or
    //equal to 10.

    @ManyToOne(optional = false)
    private Town town;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getFanBase() {
        return fanBase;
    }

    public void setFanBase(int fanBase) {
        this.fanBase = fanBase;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
