package com.example.football.models.entity;

import com.example.football.models.entity.enums.Position;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="players")
public class Player extends BaseEntity{
    @Column(name="first_name", nullable = false)
    private String firstName; //– accepts char sequences as values where their character length value higher than 2.

    @Column(name="last_name", nullable = false)
    private String lastName; // – accepts char sequences as values where their character length value higher than 2.

    @Column(nullable = false)
    private String email; // – accepts valid email addresses (must contains '@' and '.' – a dot). The values are
    // unique in the database

    @Column(name = "birth_date")
    private LocalDate birthDate; // – a date in the "dd/MM/yyyy" format.

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Position position ; //– one of the following – ATT, MID, DEF.

    @ManyToOne(optional = false)
    private Town town;

    @ManyToOne(optional = false)
    private Team team;

    @OneToOne(optional = false)
    @JoinColumn(name = "stat_id")
    private Stat stat;

    public Player() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
