import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"Craft!".equals(command)) {
            String[] commandParts = command.split(" - ");
            String firstCommand = commandParts[0];
            String item = commandParts[1];
            int index = list.indexOf(item);

            switch (firstCommand) {
                case "Collect":
                    if (list.contains(item)) {
                        break;
                    } else if (index < 0) {
                        list.add(item);
                    }
                    break;
                case "Drop":
                    if (0 <= index && index < list.size()) {
                        list.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] splitCombine = item.split(":");
                    String oldItem = splitCombine[0];
                    String newItem = splitCombine[1];
                    index = list.indexOf(oldItem) + 1;
                    if (list.contains(oldItem)) {
                        list.add(index, newItem);
                    }
                    break;
                case "Renew":
                    if (list.contains(item) && 0 <= index && index < list.size()) {
                        list.remove(item);
                        list.add(item);
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}