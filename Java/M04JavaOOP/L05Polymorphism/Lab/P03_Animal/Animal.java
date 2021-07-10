package bg.softuni.java_oop.polymorphism.lab.P03_Animal;

public abstract class Animal {
    private final String name;
    private final String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    private String getName() {
        return this.name;
    }

    private String getFavouriteFood() {
        return this.favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood());
    }
}
