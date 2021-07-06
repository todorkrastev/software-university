package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant;

import java.math.BigDecimal;

public class Food extends Product {
    protected double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }
}
