package bg.softuni.intro.cats;

import bg.softuni.intro.cats.design_pattern.speciffication.Handler;
import bg.softuni.intro.cats.model.dto.CreateOwnerDto;
import bg.softuni.intro.cats.service.OwnerService;
import bg.softuni.intro.cats.design_pattern.speciffication.HandlerFactory;
import bg.softuni.intro.ioc.Animal;
import bg.softuni.intro.ioc.Cat;
import bg.softuni.intro.ioc.Crocodile;
import bg.softuni.intro.ioc.Dog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatDemo implements CommandLineRunner {

    private final OwnerService ownerService;
    private final HandlerFactory handlerComposer;

    public CatDemo(OwnerService ownerService, HandlerFactory handlerComposer) {
        this.ownerService = ownerService;
        this.handlerComposer = handlerComposer;
    }

    @Override
    public void run(String... args) throws Exception {
        this.ownerService.createOwner(
                new CreateOwnerDto()
                        .setOwnerName("Pesho")
                        .setCatNames(List.of("Chinchila", "Gosho")));

        List<Animal> animals = List.of(new Cat().setName("Donka"),
                new Dog().setName("Gosho"),
                new Cat().setName("Maca"),
                new Crocodile().setName("Gena"));
        Handler handler = this.handlerComposer.getHandler();
        animals.forEach(handler::handle);
    }
}
