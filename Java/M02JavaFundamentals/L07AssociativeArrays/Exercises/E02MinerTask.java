import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"stop".equals(command)) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            map.putIfAbsent(resource, 0);
            map.put(resource, map.get(resource) + quantity);

            command = scanner.nextLine();
        }
        map
                .forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}