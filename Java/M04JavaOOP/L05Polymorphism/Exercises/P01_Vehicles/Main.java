package bg.softuni.java_oop.polymorphism.exercises.P01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        getCarInfo(reader, vehicles);

        getTruckInfo(reader, vehicles);

        int numOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numOfCommands; i++) {
            String line = reader.readLine();
            String[] tokens = line.trim().split("\\s+");
            String typeOfVehicle = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            if (line.contains("Drive")) {
                System.out.println(vehicles.get(typeOfVehicle).driving(argument));
            } else {
                vehicles.get(typeOfVehicle).refueling(argument);
            }
        }
        vehicles
                .forEach((key, value) -> System.out.println(value.toString()));
    }

    private static void getCarInfo(BufferedReader reader, Map<String, Vehicle> vehicles) throws IOException {
        String[] vehicleInfo = readArray(reader);
        String typeOfVehicle = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumptionLitresPerKm = Double.parseDouble(vehicleInfo[2]);
        Vehicle car = new Car(fuelQuantity, fuelConsumptionLitresPerKm);
        vehicles.put(typeOfVehicle, car);
    }

    private static void getTruckInfo(BufferedReader reader, Map<String, Vehicle> vehicles) throws IOException {
        double fuelConsumptionLitresPerKm;
        String typeOfVehicle;
        double fuelQuantity;
        String[] vehicleInfo;
        vehicleInfo = readArray(reader);
        typeOfVehicle = vehicleInfo[0];
        fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        fuelConsumptionLitresPerKm = Double.parseDouble(vehicleInfo[2]);
        Vehicle truck = new Truck(fuelQuantity, fuelConsumptionLitresPerKm);
        vehicles.put(typeOfVehicle, truck);
    }

    private static String[] readArray(BufferedReader reader) throws IOException {
        return reader.readLine().trim().split("\\s+");
    }
}
