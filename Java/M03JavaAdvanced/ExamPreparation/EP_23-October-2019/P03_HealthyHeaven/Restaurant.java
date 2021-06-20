package bg.softuni.java_advanced.exam_preparation_23_October_2019.P03_HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public List<Salad> getData() {
        return data;
    }

    public void setData(List<Salad> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
        return this.data.stream().min((s1, s2) -> Integer.compare(s1.getTotalCalories(), s2.getTotalCalories())).orElse(null);
    }

    public String generateMenu() {
        StringBuilder output = new StringBuilder();
        output.append(this.getName()).append(" have ").append(this.getData().size()).append(" salads:");
        this.data
                .forEach(e -> output.append(System.lineSeparator()).append(e));
        return output.toString();
    }
}
