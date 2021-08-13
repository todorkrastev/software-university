package core.commands.boatCommands;

import core.factories.interfaces.BoatFactory;
import core.commands.interfaces.Command;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.boats.Boat;
import repositories.Repository;

public abstract class BoatCommand implements Command {
    private Repository<Boat> boatRepository;
    private BoatFactory boatFactory;

    protected BoatCommand(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        this.boatRepository = boatRepository;
        this.boatFactory = boatFactory;
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            Boat boat = this.boatFactory.produce(args);
            if (boat != null) {
                boatRepository.add(boat);
                message = String.format("%s with model %s registered successfully.",
                        this.getClass().getSimpleName().replace("Create", "").replace("Boat", " boat"), args[1]);
            } else {
                throw new NonExistantModelException("Invalid boat model!");
            }
        } catch (ArgumentException | DuplicateModelException | NonExistantModelException e) {
            message = e.getMessage();
        }
        return message;
    }
}
