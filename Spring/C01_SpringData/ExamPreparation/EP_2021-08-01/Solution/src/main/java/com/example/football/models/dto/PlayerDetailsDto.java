package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerDetailsDto {

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement(name = "position")
    private Position position;

    @XmlElement(name = "town")
    private PlayerTownDto town;

    @XmlElement(name = "team")
    private PlayerTeamDto team;

    @XmlElement(name = "stat")
    private PlayerStatDto stat;


    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PlayerTownDto getTown() {
        return town;
    }

    public void setTown(PlayerTownDto town) {
        this.town = town;
    }

    public PlayerTeamDto getTeam() {
        return team;
    }

    public void setTeam(PlayerTeamDto team) {
        this.team = team;
    }

    public PlayerStatDto getStat() {
        return stat;
    }

    public void setStat(PlayerStatDto stat) {
        this.stat = stat;
    }
}

