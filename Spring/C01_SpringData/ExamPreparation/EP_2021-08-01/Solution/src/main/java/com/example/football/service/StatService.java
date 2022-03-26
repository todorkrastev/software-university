package com.example.football.service;

public interface StatService {
    boolean areImported();

    String readStatsFileContent() ;

    String importStats() ;

}
