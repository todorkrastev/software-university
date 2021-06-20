package bg.softuni.java_advanced.exam_preparation_23_October_2019.P03_HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public List<Vegetable> getProducts() {
        return products;
    }

    public void setProducts(List<Vegetable> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCalories() {
        return this.products.stream().mapToInt(v -> v.getCalories()).sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("* Salad ")
                .append(this.getName())
                .append(" is ")
                .append(this.getTotalCalories())
                .append(" calories and have ")
                .append(this.getProductCount())
                .append(" products:");
        this.products
                .forEach(e -> output.append(System.lineSeparator()).append(e));
        return output.toString();
    }
}
