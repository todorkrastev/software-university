import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] commandParts = command.split("\\s+");

            switch (commandParts[0]) {
                case "Add":
                    list.add(Integer.parseInt(commandParts[1]));
                    break;
                case "Insert":
                    if (0 <= Integer.parseInt(commandParts[2]) && Integer.parseInt(commandParts[2]) < list.size()) {
                        list.add(Integer.parseInt(commandParts[2]), Integer.parseInt(commandParts[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    if (0 <= Integer.parseInt(commandParts[1]) && Integer.parseInt(commandParts[1]) < list.size()) {
                        list.remove(Integer.parseInt(commandParts[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int n = Integer.parseInt(commandParts[2]);
                    int count = 0;
                    switch (commandParts[1]) {
                        case "left":
                            for (int i = 0; i < n; i++) {
                                int tempFirstIndex = list.get(i);
                                list.remove(i);
                                list.add(tempFirstIndex);
                                i = -1;
                                count++;
                                if (count == n) {
                                    break;
                                }
                            }
                            break;
                        case "right":
                            for (int i = 0; i < n; i++) {
                                int tempLastIndex = list.get(list.size() - 1);
                                list.add(i, tempLastIndex);
                                list.remove(list.size() - 1);
                                i = -1;
                                count++;
                                if (count == n) {
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}