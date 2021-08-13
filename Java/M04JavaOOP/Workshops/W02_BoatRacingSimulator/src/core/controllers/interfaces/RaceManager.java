package core.controllers.interfaces;

import exceptions.*;
import models.boats.Boat;
import models.Race;

public interface RaceManager {
    void setRace(Race race) throws RaceAlreadyExistsException;
    void addBoat(Boat boat) throws DuplicateModelException, ArgumentException, NoSetRaceException;
    void startRace() throws InsufficientContestantsException, NoSetRaceException;
    String getRaceResult();
    String getStatistics();
}
