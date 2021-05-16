package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E07FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, List<String>> map = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = reader.readLine())) {
            String email = reader.readLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                map.putIfAbsent(name, new ArrayList<>());
                if (!map.get(name).contains(email)) {
                    map.get(name).add(email);
                }
            }
        }
        map
                .forEach((k, v) -> System.out.printf("%s -> %s%n", k, String.join(", ", v)));
    }
}
