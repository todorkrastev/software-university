package E03ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E03NeedForSpeedIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());
        Map<String, int[]> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().trim().split("\\|");
            String brand = split[0];
            int mileage = Integer.parseInt(split[1]);
            int fuel = Integer.parseInt(split[2]);

            map.putIfAbsent(brand, new int[2]);
            map.get(brand)[0] = mileage;
            map.get(brand)[1] = fuel;
        }

        String input;
        while (!"Stop".equals(input = reader.readLine())) {
            String[] split = input.trim().split(" : ");
            String command = split[0];
            String car = split[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(split[2]);
                    int fuel = Integer.parseInt(split[3]);

                    if (map.get(car)[1] < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        map.get(car)[0] += distance;
                        map.get(car)[1] -= fuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (100000 <= map.get(car)[0]) {
                            map.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelR = Integer.parseInt(split[2]);

                    if (75 < map.get(car)[1] + fuelR) {
                        fuelR = 75 - map.get(car)[1];
                        map.get(car)[1] = 75;
                    } else {
                        map.get(car)[1] += fuelR;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, fuelR);
                    break;
                case "Revert":
                    int km = Integer.parseInt(split[2]);

                    if (map.get(car)[0] - km < 10000) {
                        km = 10000 - map.get(car)[0];
                        map.get(car)[0] = 10000;
                    } else {
                        map.get(car)[0] -= km;
                    }
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                    break;
                default:
                    break;
            }
        }
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
