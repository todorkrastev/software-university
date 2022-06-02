package bg.softuni.intro.cats.design_pattern.speciffication.impl;

import bg.softuni.intro.cats.design_pattern.speciffication.Handler;
import bg.softuni.intro.ioc.Animal;

public abstract class BaseHandler implements Handler {
    private Handler successor;

    @Override
    public void handle(Animal animal) {
        if (this.canHandle(animal))
        {
            this.handleStep(animal);
        }

        if (this.successor != null)
        {
            this.successor.handle(animal);
        }}

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract boolean canHandle(Animal animal);

    protected abstract void handleStep(Animal animal);

}
