package bg.softuni.java_advanced.defining_classes.lab.P01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int numOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> carInfo = new ArrayList<>();

        for (int i = 0; i < numOfCars; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            Car data = new Car(brand, model, horsePower);
            carInfo.add(data);
        }
        carInfo
                .forEach(System.out::println);
    }
}
