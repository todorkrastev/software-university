import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> mapPrice = new LinkedHashMap<>();
        Map<String, Double> mapQuantity = new LinkedHashMap<>();

        double price = 0.0;
        int quantity = 0;

        String command = scanner.nextLine();

        while (!"buy".equals(command)) {
            String[] commandParts = command.trim().split("\\s+");
            String name = commandParts[0];
            price = Double.parseDouble(commandParts[1]);
            quantity = Integer.parseInt(commandParts[2]);

            mapQuantity.putIfAbsent(name, 0.0);
            mapQuantity.put(name, mapQuantity.get(name) + quantity);
            mapPrice.put(name, mapQuantity.get(name) * price);

            command = scanner.nextLine();
        }
        mapPrice
                .forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v));
    }
}