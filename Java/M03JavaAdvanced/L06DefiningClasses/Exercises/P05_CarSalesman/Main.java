package bg.softuni.java_advanced.defining_classes.exercises.P05_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int linesOfEngines = Integer.parseInt(reader.readLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < linesOfEngines; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (tokens.length == 4) {
                displacement = tokens[2];
                efficiency = tokens[3];

            } else if (tokens.length == 3) {
                try {
                    Integer.parseInt(tokens[2]);
                    displacement = tokens[2];
                } catch (NumberFormatException e) {
                    efficiency = tokens[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);

            engineList.add(engine);
        }
        int linesOfCars = Integer.parseInt(reader.readLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < linesOfCars; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];
            String weight = "n/a";
            String color = "n/a";

            if (tokens.length == 4) {
                weight = tokens[2];
                color = tokens[3];
            } else if (tokens.length == 3) {
                try {
                    Integer.parseInt(tokens[2]);
                    weight = tokens[2];
                } catch (NumberFormatException e) {
                    color = tokens[2];
                }
            }
            Engine dataEngine = engineList.stream().filter(data -> data.getModel().equals(engine)).findFirst().orElseThrow();
            Car car = new Car(model, dataEngine, weight, color);

            carList.add(car);
        }
        carList
                .forEach(System.out::println);
    }
}
