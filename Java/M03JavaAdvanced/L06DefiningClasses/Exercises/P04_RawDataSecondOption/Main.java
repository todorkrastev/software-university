package bg.softuni.java_advanced.defining_classes.exercises.P04_RawDataSecondOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            String model = input[0];
            int enginePower = Integer.parseInt(input[2]);
            String cargoType = input[4];
            double firstTyre = Double.parseDouble(input[5]);
            double secondTyre = Double.parseDouble(input[7]);
            double thirdTyre = Double.parseDouble(input[9]);
            double fourthTyre = Double.parseDouble(input[11]);

            Car data = new Car(model, enginePower, cargoType, firstTyre
                    , secondTyre, thirdTyre, fourthTyre);
            carList.add(data);
        }

        String cargoType = reader.readLine();

        if (cargoType.equals("fragile")) {
            carList.stream().filter(e -> e.getCargoType().equals("fragile")
                    && e.tirePressure()).forEach(System.out::println);
        } else {
            carList.stream().filter(e -> e.getCargoType().equals("flamable")
                    && e.getEnginePower() > 250).forEach(System.out::println);
        }
    }
}
