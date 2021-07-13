package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm;

import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals.*;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Food;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Meat;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Animal> animalList = new ArrayList<>();

        String evenLine;
        while (!"End".equalsIgnoreCase(evenLine = reader.readLine())) {
            Animal animal = createAnimal(evenLine.trim().split("\\s+"));

            String oddLine = reader.readLine();

            Food food = createFood(oddLine.trim().split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animalList.add(animal);
        }
        animalList
                .forEach(animal -> System.out.println(animal.toString()));
    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Meat")
                ? new Meat(quantity)
                : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[1], "Cat", Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            case "Tiger":
                return new Tiger(tokens[1], "Tiger", Double.parseDouble(tokens[2]), tokens[3]);
            case "Zebra":
                return new Zebra(tokens[1], "Zebra", Double.parseDouble(tokens[2]), tokens[3]);
            case "Mouse":
                return new Mouse(tokens[1], "Mouse", Double.parseDouble(tokens[2]), tokens[3]);
            default:
                throw new IllegalStateException("Unknown animal type " + tokens[0]);
        }
    }
}
