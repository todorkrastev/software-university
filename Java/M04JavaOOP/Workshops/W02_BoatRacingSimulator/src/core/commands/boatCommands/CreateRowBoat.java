package core.commands.boatCommands;

import core.factories.interfaces.BoatFactory;
import models.boats.Boat;
import repositories.Repository;

public class CreateRowBoat extends BoatCommand {
    public CreateRowBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
