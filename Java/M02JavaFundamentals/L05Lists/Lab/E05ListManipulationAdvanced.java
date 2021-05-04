import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];
            String commandType = inputParts[1];

            switch (command) {
                case "Contains":
                    if (list.contains(Integer.parseInt(commandType))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if ("even".equals(commandType)) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) % 2 == 0) {
                                System.out.print(list.get(i) + " ");
                            }
                        }
                    } else if ("odd".equals(commandType)) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) % 2 == 1) {
                                System.out.print(list.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    if ("sum".equals(commandType)) {
                        int sum = 0;
                        for (Integer element : list) {
                            sum += element;
                        }
                        System.out.println(sum);
                    }
                    break;
                case "Filter":
                    String commandIndex = inputParts[2];
                    int commandIndexInt = Integer.parseInt(commandIndex);

                    switch (commandType) {
                        case "<":
                            for (int i = 0; i < list.size(); i++) {
                                if (commandIndexInt > list.get(i))
                                    System.out.print(list.get(i) + " ");
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < list.size(); i++) {
                                if (commandIndexInt >= list.get(i))
                                    System.out.print(list.get(i) + " ");
                            }
                            System.out.println();
                            break;

                        case ">":
                            for (int i = 0; i < list.size(); i++) {
                                if (commandIndexInt < list.get(i))
                                    System.out.print(list.get(i) + " ");
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int i = 0; i < list.size(); i++) {
                                if (commandIndexInt <= list.get(i))
                                    System.out.print(list.get(i) + " ");
                            }
                            System.out.println();
                            break;
                    }
            }
            input = scanner.nextLine();
        }
    }
}
