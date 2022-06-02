package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.ioc.Animal;
import bg.softuni.intro.ioc.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogVoiceService extends BaseHandler {

    @Override
    protected boolean canHandle(Animal animal) {
        return animal instanceof Dog;
    }

    @Override
    protected void handleStep(Animal animal) {
        synchronized (animal) {
            System.out.println(String.format("The dog %s says: %s", animal.getName(), animal.makeNoise()));
            animal.makeNoise();
        }
    }
}
