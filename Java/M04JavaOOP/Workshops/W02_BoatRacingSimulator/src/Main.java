import core.commandInterpreter.CommandHandler;
import core.factories.BoatWorkshop;
import core.factories.CommandWorkshop;
import core.controllers.MainController;
import core.factories.EngineWorkshop;
import core.factories.interfaces.CommandFactory;
import io.InputManager;
import io.OutputManager;
import models.boats.Boat;
import models.engines.Engine;
import core.controllers.RaceController;
import repositories.Repository;
import repositories.RepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Repository<Boat> boatRepository = new RepositoryImpl<>();
        Repository<Engine> engineRepository = new RepositoryImpl<>();
        CommandFactory commandFactory =
                new CommandWorkshop(new EngineWorkshop(), new BoatWorkshop(engineRepository), engineRepository, boatRepository, new RaceController());
        MainController controller = new MainController(new InputManager(), new OutputManager(), new CommandHandler(commandFactory));
        controller.run();
    }
}
