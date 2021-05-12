package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class E06ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Map<String, Double>> map = new TreeMap<>();

        String input;
        while (!"Revision".equals(input = reader.readLine())) {
            String[] split = input.trim().split(", ");
            String shop = split[0];
            String product = split[1];
            double price = Double.parseDouble(split[2]);

            map.putIfAbsent(shop, new LinkedHashMap<>());
            map.get(shop).putIfAbsent(product, price);
        }
        map
                .forEach((k, v) -> {
                    System.out.printf("%s->%n", k);
                    v
                            .forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
                });
    }
}
