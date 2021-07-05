package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] pizzaInfo = reader.readLine().trim().split("\\s+");
        String name = pizzaInfo[1];
        int countOfToppings = Integer.parseInt(pizzaInfo[2]);

        try {
            Pizza pizza = new Pizza(name, countOfToppings);

            String[] doughInfo = reader.readLine().trim().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double weight = Double.parseDouble(doughInfo[3]);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String input;

            while (!"END".equals(input = reader.readLine())) {

                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

