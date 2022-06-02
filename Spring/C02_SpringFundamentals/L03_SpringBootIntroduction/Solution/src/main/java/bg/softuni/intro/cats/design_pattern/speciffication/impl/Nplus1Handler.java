package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.ioc.Animal;
import org.springframework.stereotype.Service;

@Service
public class Nplus1Handler extends BaseHandler {
    @Override
    protected boolean canHandle(Animal animal) {
        return false;
    }

    @Override
    protected void handleStep(Animal animal) {
        //Do something
    }
}
