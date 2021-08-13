package core.factories;

import core.factories.interfaces.BoatFactory;
import exceptions.ArgumentException;
import exceptions.NonExistantModelException;
import models.boats.*;
import models.engines.Engine;
import repositories.Repository;

public class BoatWorkshop implements BoatFactory {
    private Repository<Engine> engineRepository;

    public BoatWorkshop(Repository<Engine> engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public Boat produce(String[] args) throws ArgumentException, NonExistantModelException {

        String typeContainer = args[0];

        Boat boat = null;

        if (typeContainer.contains("Row")) {
            boat = new RowBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (typeContainer.contains("Sail")) {
            boat = new SailBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (typeContainer.contains("Power")) {
            boat = new PowerBoat(args[1], Integer.parseInt(args[2]),
                    this.engineRepository.get(args[3]),
                    this.engineRepository.get(args[4]));
        } else if (typeContainer.contains("Yacht")) {
            boat = new Yacht(args[1], Integer.parseInt(args[2]),
                    this.engineRepository.get(args[3]),
                    Integer.parseInt(args[4]));
        }

        return boat;
    }
}
