package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;

public class E01ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Set<String> set = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] split = input.trim().split(", ");
            String direction = split[0];
            String plateNum = split[1];

            if ("IN".equals(direction)) {
                set.add(plateNum);
            } else if ("OUT".equals(direction)) {
                set.remove(plateNum);
            }
        }
        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            set
                    .forEach(System.out::println);
        }
    }
}
