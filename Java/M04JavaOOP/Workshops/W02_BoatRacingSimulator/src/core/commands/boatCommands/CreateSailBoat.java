package core.commands.boatCommands;

import core.factories.interfaces.BoatFactory;
import models.boats.Boat;
import repositories.Repository;

public class CreateSailBoat extends BoatCommand {
    public CreateSailBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
