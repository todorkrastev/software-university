package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

public class BestPlayerDto {
    private String firstName;
    private String lastName;
    private Position position;
    private String teamName;
    private String stadiumName;

    public BestPlayerDto(String firstName, String lastName, Position position, String teamName, String stadiumName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.teamName = teamName;
        this.stadiumName = stadiumName;
    }

    @Override
    public String toString() {
        return String.format("""
                        Player - %s %s
                        \tPosition - %s
                        \tTeam - %s
                        \tStadium - %s""",
                this.firstName,
                this.lastName,
                this.position.name(),
                this.teamName,
                this.stadiumName);
    }
}
