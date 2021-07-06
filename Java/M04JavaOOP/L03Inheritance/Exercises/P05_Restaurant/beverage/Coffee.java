package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant.beverage;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    protected static final double COFFEE_MILLILITERS = 50;
    protected static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private final double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return this.caffeine;
    }
}
