package raceManager.core;

import raceManager.models.Athlete;

import java.util.Collection;
import java.util.Iterator;

public interface RaceManger {
    void enroll(Athlete athlete);
    boolean isEnrolled(Athlete athlete);
    void start();
    void retire(Athlete athlete);
    void finish(Athlete athlete);
    Athlete getLastFinishedAthlete();
    int currentRacingCount();
    Collection<Athlete> getAllAthletesByAge();
    Collection<Athlete> getAllNotFinishedAthletes();
    Iterator<Athlete> getScoreBoard();
}
