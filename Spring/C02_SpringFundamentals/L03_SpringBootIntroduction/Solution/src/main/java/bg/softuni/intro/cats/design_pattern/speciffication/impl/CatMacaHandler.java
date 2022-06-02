package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.ioc.Animal;
import bg.softuni.intro.ioc.Cat;
import org.springframework.stereotype.Service;

@Service
public class CatMacaHandler extends BaseHandler{

    public static final String CAT_NAME = "Maca";

    @Override
    protected boolean canHandle(Animal animal) {
        return animal instanceof Cat && animal.getName().equals(CAT_NAME);
    }

    @Override
    protected void handleStep(Animal animal) {
        System.out.println(String.format("The cat %s jump jump.", animal.getName()));
    }
}
