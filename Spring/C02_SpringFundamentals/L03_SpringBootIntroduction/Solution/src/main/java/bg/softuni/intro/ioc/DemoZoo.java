package bg.softuni.intro.ioc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoZoo implements CommandLineRunner {

    private final ZooService service;

    public DemoZoo(ZooService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        this.service.doWork();
    }
}
