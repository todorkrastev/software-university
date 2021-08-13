package models.interfaces;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import exceptions.InsufficientContestantsException;
import models.boats.Boat;

import java.util.Set;

public interface RaceModel {
    int getDistance();
    int getCurrentSpeed();
    int getWindSpeed();
    boolean allowsMotorBoats();
    Set<Boat> getParticipants();
    void startRace() throws InsufficientContestantsException;
    void addParticipant(Boat participant) throws DuplicateModelException, ArgumentException;
    String getStatistics();
    String getResult();
}
