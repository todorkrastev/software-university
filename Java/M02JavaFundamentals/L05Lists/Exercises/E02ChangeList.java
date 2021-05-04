import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandParts = command.split("\\s+");

            switch (commandParts[0]) {
                case "Delete":
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == Integer.parseInt(commandParts[1])) {
                            list.remove(i);
                        }
                    }
                    break;
                case "Insert":
                    if (0 <= Integer.parseInt(commandParts[2]) && Integer.parseInt(commandParts[2]) < list.size()) {
                        list.add(Integer.parseInt(commandParts[2]), Integer.parseInt(commandParts[1]));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
