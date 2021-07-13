package bg.softuni.java_oop.polymorphism.exercises.P02_VehicleExtended;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(reader.readLine().trim().split("\\s+")));
        vehicleMap.put("Truck", createVehicle(reader.readLine().trim().split("\\s+")));

        Bus bus = createBus(reader.readLine().trim().split("\\s+"));

        vehicleMap.put("Bus", bus);

        int commandsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandsCount; i++) {
            String command = reader.readLine();

            String[] params = command.trim().split("\\s+");

            double argument = Double.parseDouble(params[2]);

            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.drivingWithPassengers(argument));
            } else if (command.contains("Drive")) {
                System.out.println(vehicleMap.get(params[1]).driving(argument));
            } else {
                try {
                    vehicleMap.get(params[1]).refueling(argument);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        vehicleMap
                .forEach((key, value) -> System.out.println(value.toString()));
    }

    private static Bus createBus(String[] tokens) {
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicle = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        switch (vehicle) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus":
                return createBus(tokens);
            default:
                throw new IllegalArgumentException("Unknown vehicle type for " + vehicle);
        }
    }
}
