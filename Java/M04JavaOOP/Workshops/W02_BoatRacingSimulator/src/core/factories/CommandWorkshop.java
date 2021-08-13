package core.factories;

import core.commands.*;
import core.commands.boatCommands.*;
import core.commands.interfaces.Command;
import core.commands.raceCommands.GetStatistic;
import core.commands.raceCommands.OpenRace;
import core.commands.raceCommands.SignUpBoat;
import core.commands.raceCommands.StartRace;
import core.factories.interfaces.BoatFactory;
import core.factories.interfaces.CommandFactory;
import core.factories.interfaces.EngineFactory;
import models.boats.Boat;
import models.engines.Engine;
import core.controllers.interfaces.RaceManager;
import repositories.Repository;

public class CommandWorkshop implements CommandFactory {
    private EngineFactory engineFactory;
    private BoatFactory boatFactory;
    private Repository<Engine> engineRepository;
    private Repository<Boat> boatRepository;
    private RaceManager raceManager;

    public CommandWorkshop(EngineFactory engineFactory, BoatFactory boatFactory,
                           Repository<Engine> engineRepository, Repository<Boat> boatRepository,
                           RaceManager raceManager) {
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;
        this.engineRepository = engineRepository;
        this.boatRepository = boatRepository;
        this.raceManager = raceManager;
    }

    @Override
    public Command produce(String type) {
        Command command = null;

        if (type.equals("CreateBoatEngine")) {
            command = new CreateBoatEngine(this.engineRepository, this.engineFactory);
        } else if (type.equals("CreateRowBoat")) {
            command = new CreateRowBoat(this.boatRepository, this.boatFactory);
        } else if (type.equals("CreateSailBoat")) {
            command = new CreateSailBoat(this.boatRepository, this.boatFactory);
        } else if (type.equals("CreatePowerBoat")) {
            command = new CreatePowerBoat(this.boatRepository, this.boatFactory);
        } else if (type.equals("CreateYacht")) {
            command = new CreateYacht(this.boatRepository, this.boatFactory);
        } else if (type.equals("OpenRace")) {
            command = new OpenRace(this.raceManager);
        } else if (type.equals("SignUpBoat")) {
            command = new SignUpBoat(this.raceManager, this.boatRepository);
        } else if (type.equals("StartRace")) {
            command = new StartRace(this.raceManager);
        } else if (type.equals("GetStatistic")) {
            command = new GetStatistic(this.raceManager);
        }else if (type.equals("End")) {
            command = new End();
        }

        return command;
    }
}
