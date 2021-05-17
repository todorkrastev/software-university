package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class E10PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Map<String, Integer>> map = new HashMap<>();

        String input;
        while (!"report".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\|");
            String city = split[0];
            String country = split[1];
            int population = Integer.parseInt(split[2]);

            map.putIfAbsent(country, new HashMap<>());
            map.get(country).putIfAbsent(city, 0);
            map.get(country).put(city, population);
        }
        map
                .entrySet()
                .stream()
                .sorted((first, second) ->
                        Long.compare(second.getValue().values().stream().mapToLong(i -> i).sum()
                                , first.getValue().values().stream().mapToLong(i -> i).sum()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n",
                            e.getKey(), e.getValue().values().stream().mapToLong(i -> i).sum());
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(entry -> System.out.printf("=>%s: %d%n", entry.getKey(), entry.getValue()));
                });
    }
}
