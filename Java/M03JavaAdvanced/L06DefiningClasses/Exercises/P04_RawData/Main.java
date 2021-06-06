package bg.softuni.java_advanced.defining_classes.exercises.P04_RawData;

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
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tyre[] tyres = new Tyre[4];

            int count = 0;
            for (int j = 5; j < input.length; j += 2) {
                double tyrePressure = Double.parseDouble(input[j]);
                int tyreAge = Integer.parseInt(input[j + 1]);
                tyres[count] = new Tyre(tyrePressure, tyreAge);
                count++;
            }
            Car car = new Car(model, engine, cargo, tyres);
            carMap.putIfAbsent(model, car);
        }
        String cargoType = reader.readLine();
        for (Car car : carMap.values()) {
            if ("flamable".equals(cargoType) && "flamable".equals(car.getCargo().getCargoType()) && car.getEngine().getEnginePower() > 250) {
                System.out.println(car);
            } else if ("fragile".equals(cargoType) && "fragile".equals(car.getCargo().getCargoType()) && car.hasTyreWithLessPressureThanOne()) {
                System.out.println(car);
            }
        }
    }
}
