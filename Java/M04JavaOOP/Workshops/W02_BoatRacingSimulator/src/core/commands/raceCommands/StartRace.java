package core.commands.raceCommands;

import exceptions.InsufficientContestantsException;
import exceptions.NoSetRaceException;
import core.controllers.interfaces.RaceManager;

public class StartRace extends RaceCommand {
    public StartRace(RaceManager raceController) {
        super(raceController);
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            this.getRaceController().startRace();
            message = this.getRaceController().getRaceResult();
        } catch (InsufficientContestantsException | NoSetRaceException e) {
           message = e.getMessage();
        }

        return message;
    }
}
