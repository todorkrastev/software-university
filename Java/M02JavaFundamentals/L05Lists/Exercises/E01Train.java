import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandParts = command.split("\\s+");

            if ("Add".equals(commandParts[0])) {
                wagons.add(Integer.parseInt(commandParts[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + Integer.parseInt(commandParts[0]) <= capacity) {
                        wagons.add(i, wagons.get(i) + Integer.parseInt(commandParts[0]));
                        wagons.remove(i + 1);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
