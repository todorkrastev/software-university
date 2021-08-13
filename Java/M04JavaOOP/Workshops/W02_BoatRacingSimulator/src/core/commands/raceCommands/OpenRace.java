package core.commands.raceCommands;

import core.factories.interfaces.RaceFactory;
import core.factories.RaceWorkshop;
import exceptions.ArgumentException;
import exceptions.RaceAlreadyExistsException;
import models.Race;
import core.controllers.interfaces.RaceManager;

public class OpenRace extends RaceCommand {
    private RaceFactory raceFactory;

    public OpenRace(RaceManager raceController) {
        super(raceController);
        raceFactory = new RaceWorkshop();
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            Race race = this.raceFactory.produce(args);
            this.getRaceController().setRace(race);
            message =
                    String.format(
                            "A new race with distance %d meters, " +
                                    "wind speed %d m/s and ocean current speed %d m/s has been set.",
                    race.getDistance(), race.getWindSpeed(), race.getCurrentSpeed());
        } catch (ArgumentException | RaceAlreadyExistsException e) {
            message = e.getMessage();
        }

        return message;
    }
}
