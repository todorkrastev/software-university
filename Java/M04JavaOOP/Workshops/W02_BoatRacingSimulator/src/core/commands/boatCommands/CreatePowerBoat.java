package core.commands.boatCommands;

import core.factories.interfaces.BoatFactory;
import models.boats.Boat;
import repositories.Repository;

public class CreatePowerBoat extends BoatCommand {
    public CreatePowerBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
