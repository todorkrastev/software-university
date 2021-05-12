package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class E07CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());

        Map<String, Map<String, LinkedList<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String[] split = reader.readLine().trim().split("\\s+");
            String continent = split[0];
            String country = split[1];
            String city = split[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new LinkedList<>());
            map.get(continent).get(country).add(city);
        }
        map
                .forEach((key, value) -> {
                    System.out.printf("%s:%n", key);
                    value
                            .forEach((k, v) -> {
                                System.out.printf("%s -> ", k);
                                System.out.println(String.join(", ", v));
                            });
                });
    }
}
