package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.ioc.Animal;
import bg.softuni.intro.ioc.Cat;
import org.springframework.stereotype.Service;

@Service
public class CatDressUpHandler extends BaseHandler {
    @Override
    protected boolean canHandle(Animal animal) {
        return animal instanceof Cat;
    }

    @Override
    protected void handleStep(Animal animal) {
        System.out.println(String.format("The cat %s was dressed up.", animal.getName()));
    }
}
