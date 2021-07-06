package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant.beverage;

import bg.softuni.java_oop.inheritance.exercises.P05_Restaurant.beverage.HotBeverage;

import java.math.BigDecimal;

public class Tea extends HotBeverage {
    public Tea(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
