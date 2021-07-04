package bg.softuni.java_oop.encapsulation.exercises.P03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        this.money -= product.getCost();
        this.products.add(product);
        System.out.printf("%s bought %s%n", this.getName(), product.getName());
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output
                .append(this.getName())
                .append(" - ");
        output
                .append(this.products.isEmpty() ? "Nothing bought"
                        : output
                        .append(products.stream().map(Product::getName).collect(Collectors.joining(", ")))
                        .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
