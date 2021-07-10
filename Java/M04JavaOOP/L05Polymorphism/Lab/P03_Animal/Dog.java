package bg.softuni.java_oop.polymorphism.lab.P03_Animal;

public class Dog extends Animal {


    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nDJAAF", super.explainSelf());
    }
}
