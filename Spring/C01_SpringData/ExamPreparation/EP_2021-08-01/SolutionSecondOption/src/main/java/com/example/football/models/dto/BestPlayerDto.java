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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Player - %s %s", firstName, lastName)).append(System.lineSeparator());
        sb.append(String.format("\tPosition - %s", position)).append(System.lineSeparator());
        sb.append(String.format("\tTeam - %s", teamName)).append(System.lineSeparator());
        sb.append(String.format("\tStadium - %s", stadiumName));
        return sb.toString();
    }
}
