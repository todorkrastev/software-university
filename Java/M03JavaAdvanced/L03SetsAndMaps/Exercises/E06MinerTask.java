package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class E06MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Integer> map = new LinkedHashMap<>();

        String resources;
        while (!"stop".equals(resources = reader.readLine())) {
            int quantity = Integer.parseInt(reader.readLine());

            map.put(resources, !map.containsKey(resources) ? quantity : map.get(resources) + quantity);
        }
        map
                .forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
