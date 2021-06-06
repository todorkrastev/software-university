package bg.softuni.java_advanced.defining_classes.exercises.P03_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());

        Map<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostPerKm = Double.parseDouble(input[2]);
            int traveledDistance = 0;

            Car car = new Car(model, fuelAmount, fuelCostPerKm, traveledDistance);
            carMap.put(model, car);
        }
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String model = tokens[1];
            int kmDistance = Integer.parseInt(tokens[2]);

            Car carToDrive = carMap.get(model);

            if (!carToDrive.drive(kmDistance)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        carMap
                .forEach((k, v) -> System.out.printf("%s %.2f %d%n",
                        k, v.getFuelAmount(), v.getTraveledDistance()));
    }
}
