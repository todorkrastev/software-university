import java.util.*;

public class E03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterial = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();

        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained) {
            String[] array = scanner.nextLine().toLowerCase().trim().split("\\s+");
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
                .forEach(i -> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));
        junk
                .entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }
}