package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {

    protected static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
