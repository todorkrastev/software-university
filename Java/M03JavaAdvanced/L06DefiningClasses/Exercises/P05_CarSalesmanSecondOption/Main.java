package bg.softuni.java_advanced.defining_classes.exercises.P05_CarSalesmanSecondOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Engine> engineMap = new HashMap<>();

        int linesOfEngines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < linesOfEngines; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;
            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\d+$")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.putIfAbsent(model, engine);
        }
        List<Car> cars = new LinkedList<>();

        int linesOfCars = Integer.parseInt(reader.readLine());

        for (int i = 0; i < linesOfCars; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);

            Car car = null;
            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        cars
                .forEach(System.out::println);
    }
}
