package bg.softuni.intro.cats.design_pattern.speciffication;

import bg.softuni.intro.ioc.Animal;

public interface Handler {

    void handle(Animal animal);

    void setSuccessor(Handler successor);

}
