package core.commands.boatCommands;

import core.factories.interfaces.EngineFactory;
import core.commands.interfaces.Command;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.engines.Engine;
import repositories.Repository;

public class CreateBoatEngine implements Command {
    private Repository<Engine> engineRepository;
    private EngineFactory engineFactory;

    public CreateBoatEngine(Repository<Engine> engineRepository, EngineFactory engineFactory) {
        this.engineRepository = engineRepository;
        this.engineFactory = engineFactory;
    }

    @Override
    public String execute(String[] args) {
        String result = null;
        try {
            this.engineRepository.add(this.engineFactory.produce(args));
            result = String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.", args[1], args[2], args[3]);
        } catch (ArgumentException | DuplicateModelException ex) {
            result = ex.getMessage();
        }
        return result;
    }
}
