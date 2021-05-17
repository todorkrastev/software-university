package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class E12LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Integer> keyMaterial = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();

        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained) {
            String[] array = reader.readLine().toLowerCase().trim().split("\\s+");
            for (int i = 0; i < array.length; i += 2) {
                int quantity = Integer.parseInt(array[i]);
                String material = array[i + 1];

                switch (material) {
                    case "shards":
                        keyMaterial.putIfAbsent(material, 0);
                        keyMaterial.put(material, keyMaterial.get(material) + quantity);
                        if (250 <= keyMaterial.get(material)) {
                            int newQuantity = keyMaterial.get(material) - 250;
                            keyMaterial.put(material, newQuantity);
                            System.out.println("Shadowmourne obtained!");
                            isObtained = true;
                        }
                        break;
                    case "fragments":
                        keyMaterial.putIfAbsent(material, 0);
                        keyMaterial.put(material, keyMaterial.get(material) + quantity);
                        if (250 <= keyMaterial.get(material)) {
                            int newQuantity = keyMaterial.get(material) - 250;
                            keyMaterial.put(material, newQuantity);
                            System.out.println("Valanyr obtained!");
                            isObtained = true;
                        }
                        break;
                    case "motes":
                        keyMaterial.putIfAbsent(material, 0);
                        keyMaterial.put(material, keyMaterial.get(material) + quantity);
                        if (250 <= keyMaterial.get(material)) {
                            int newQuantity = keyMaterial.get(material) - 250;
                            keyMaterial.put(material, newQuantity);
                            System.out.println("Dragonwrath obtained!");
                            isObtained = true;
                        }
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        junk.put(material, junk.get(material) + quantity);
                        break;
                }
                if (isObtained) {
                    break;
                }
            }
        }
        keyMaterial
                .entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = i2.getValue().compareTo(i1.getValue());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
        junk
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }
}
