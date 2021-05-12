package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class E04CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] input = reader.readLine().trim().split("\\s+");

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (String s : input) {
            double currNum = Double.parseDouble(s);

            map.putIfAbsent(currNum, 0);
            map.put(currNum, map.get(currNum) + 1);
        }
        map
                .forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
