package bg.softuni.java_advanced.defining_classes.exercises.P03_SpeedRacingSecondOption;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static bg.softuni.java_advanced.defining_classes.exercises.P03_SpeedRacingSecondOption.Car.drivingCar;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carMap = new LinkedHashMap<>();

        IntStream.range(0, num).mapToObj(i -> scanner.nextLine().trim().split("\\s+")).forEach(input -> {
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelPricePerKilometer = Double.parseDouble(input[2]);
            Car data = new Car(model, fuelAmount, fuelPricePerKilometer, 0);
            carMap.put(model, data);
        });

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");
            drivingCar(carMap.get(command[1]), Integer.parseInt(command[2]));
        }

        carMap.forEach((key, value) -> System.out.printf("%s %.2f %d%n"
                , key, value.getFuelAmount(), value.getTraveledDistance()));

    }
}

