import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command;

        while (!"end".equals(command = scanner.nextLine())) {
            String[] commandParts = command.trim().split("\\s+");

            String firstCommand = commandParts[0];

            switch (firstCommand) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex = Integer.parseInt(commandParts[2]);
                    int temp = list.get(firstIndex);
                    firstIndex = list.set(firstIndex, list.get(secondIndex));
                    secondIndex = list.set(secondIndex, temp);
                    break;
                case "multiply":
                    firstIndex = Integer.parseInt(commandParts[1]);
                    secondIndex = Integer.parseInt(commandParts[2]);
                    int result = list.get(firstIndex) * list.get(secondIndex);
                    list.set(firstIndex, result);
                    break;
                case "decrease":
                    for (int i = list.size() - 1; i >= 0; i--) {
                        list.set(i, list.get(i) - 1);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}
