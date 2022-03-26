package com.example.football.service;

public interface TeamService {
    boolean areImported();

    String readTeamsFileContent() ;

    String importTeams() ;

}
