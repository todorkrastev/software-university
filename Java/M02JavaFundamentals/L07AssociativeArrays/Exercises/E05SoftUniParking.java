import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().trim().split("\\s+");
            String command = commandParts[0];
            String username = commandParts[1];

            switch (command) {
                case "register":
                    String plateNum = commandParts[2];
                    if (!map.containsKey(username)) {
                        map.put(username, plateNum);
                        System.out.printf("%s registered %s successfully%n", username, plateNum);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNum);
                    }
                    break;
                case "unregister":
                    if (map.containsKey(username)) {
                        System.out.printf("%s unregistered successfully%n", username);
                        map.remove(username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
                default:
                    break;
            }
        }
        map
                .forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}