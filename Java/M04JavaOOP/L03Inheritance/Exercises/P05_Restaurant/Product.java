package bg.softuni.java_oop.inheritance.exercises.P05_Restaurant;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
