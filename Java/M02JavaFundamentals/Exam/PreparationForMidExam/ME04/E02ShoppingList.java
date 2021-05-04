import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().trim().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"Go Shopping!".equals(command)) {
            String[] commandParts = command.trim().split("\\s+");
            String firstCommand = commandParts[0];
            String item = commandParts[1];
            int index = list.indexOf(item);

            switch (firstCommand) {
                case "Urgent":
                    if (index < 0) {
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (0 <= index && index < list.size()) {
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    String oldItem = commandParts[1];
                    String newItem = commandParts[2];
                    index = list.indexOf(oldItem);
                    if (0 <= index && index < list.size()) {
                        list.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    if (0 <= index && index < list.size()) {
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
