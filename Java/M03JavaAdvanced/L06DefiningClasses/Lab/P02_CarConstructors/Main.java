package bg.softuni.java_advanced.defining_classes.lab.P02_CarConstructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        final int n = Integer.parseInt(reader.readLine());

        List<Car> carInfo = new ArrayList<>();

        Car.setDefaultModel("unknown");
        Car.setDefaultHorsepower(-1);

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            String brand = input[0];

            Car car;
            if (input.length == 1) {
                car = new Car(brand);
            } else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);

                car = new Car(brand, model, horsePower);
            }
            carInfo.add(car);
        }
        Consumer<Car> printer = System.out::println;

        carInfo
                .forEach(printer);
    }
}
