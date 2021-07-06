package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {

    protected double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
