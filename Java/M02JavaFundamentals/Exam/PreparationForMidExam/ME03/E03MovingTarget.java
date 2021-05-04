import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = "";

        while (!"End".equals(command = scanner.nextLine())) {
            String[] commandParts = command.split("\\s+");
            String firstCommand = commandParts[0];
            int index = Integer.parseInt(commandParts[1]);


            switch (firstCommand) {
                case "Shoot":
                    String power = commandParts[2];
                    if (0 <= index && index < list.size()) {
                        int newPower = list.get(index) - Integer.parseInt(power);
                        if (0 < newPower) {
                            list.set((index), newPower);
                        } else if (newPower <= 0) {
                            list.remove(index);
                        }
                    }
                    break;
                case "Add":
                    String value = commandParts[2];
                    if (0 <= index && index < list.size()) {
                        list.add((index), Integer.parseInt(value));
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commandParts[2]);
                    int leftLimit = index - radius;
                    int rightLimit = index + radius;
                    if (0 <= leftLimit && rightLimit < list.size()) {
                        for (int i = rightLimit; i >= leftLimit; i--) {
                            list.remove(i);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
                default:
                    break;
            }
            if (list.isEmpty()) {
                break;
            }
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", "").replaceAll(",", "|").replaceAll("\\s+", ""));
    }
}
