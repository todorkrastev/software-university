package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {

    protected double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return this.milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
