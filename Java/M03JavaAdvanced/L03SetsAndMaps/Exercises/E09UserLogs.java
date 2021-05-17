package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class E09UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, HashMap<String, Integer>> map = new TreeMap<>();


        String input;
        while (!"end".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\s+");
            String ip = split[0].split("=")[1];
            String user = split[2].split("=")[1];

            map.putIfAbsent(user, new LinkedHashMap<>());
            map.get(user).putIfAbsent(ip, 0);
            map.get(user).put(ip, map.get(user).get(ip) + 1);

        }
        map
                .forEach((k, v) -> {
                    System.out.printf("%s:%n", k);
                    int count = 1;
                    for (Map.Entry<String, Integer> entry : v.entrySet()) {
                        String output = String.format(count < v.entrySet().size()
                                ? "%s => %d, " : "%s => %d.%n", entry.getKey(), entry.getValue());
                        System.out.printf("%s", output);
                        count++;
                    }
                });
    }
}
