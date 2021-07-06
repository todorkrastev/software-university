package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant.beverage;

import bg.softuni.java_oop.inheritance.exercises.P05_Restaurant.beverage.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
