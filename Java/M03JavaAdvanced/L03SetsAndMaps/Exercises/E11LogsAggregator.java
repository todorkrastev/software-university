package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E11LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in, StandardCharsets.UTF_8));

        int numOfCustomers = Integer.parseInt(reader.readLine());

        Map<String, Map<String, Integer>> map = new TreeMap<>();

        for (int i = 0; i < numOfCustomers; i++) {
            String[] split = reader.readLine().trim().split("\\s+");
            String ip = split[0];
            String name = split[1];
            int duration = Integer.parseInt(split[2]);

            map.putIfAbsent(name, new TreeMap<>());
            map.get(name).putIfAbsent(ip, 0);
            map.get(name).put(ip, map.get(name).get(ip) + duration);
        }
        map
                .forEach((key, value) -> System.out.printf("%s: %d [%s]%n", key,
                        value.values().stream().mapToInt(v -> v).sum(), String.join(", ", value.keySet())));
    }
}
