package core.commands.raceCommands;

import core.controllers.interfaces.RaceManager;

public class GetStatistic extends RaceCommand {
    public GetStatistic(RaceManager raceController) {
        super(raceController);
    }

    @Override
    public String execute(String[] args) {
        return this.getRaceController().getStatistics();
    }
}
