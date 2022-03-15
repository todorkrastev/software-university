package bg.softuni.gamestore;

import bg.softuni.gamestore.core.Engine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Engine engine;

    public CommandLineRunnerImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void run(String... args) throws Exception {
        this.engine.run();
    }
}
