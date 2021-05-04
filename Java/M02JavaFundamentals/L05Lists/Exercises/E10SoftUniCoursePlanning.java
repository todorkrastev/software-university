import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"course start".equals(command)) {
            String[] commandParts = command.split(":");
            String[] elementParts = new String[list.size()];
            String element = "";

            switch (commandParts[0]) {
                case "Add":
                    if (list.contains(commandParts[1])) {
                        break;
                    } else {
                        list.add(commandParts[1]);
                    }
                    break;
                case "Insert":
                    if (list.contains(commandParts[1])) {
                        break;
                    } else if (0 <= Integer.parseInt(commandParts[2]) && Integer.parseInt(commandParts[2]) < list.size()) {
                        list.add(Integer.parseInt(commandParts[2]), commandParts[1]);
                    }
                    break;
                case "Remove":
                    if (list.contains(commandParts[1])) {
                        list.remove(commandParts[1]);
                    }
                    break;
                case "Swap":
                    int firstIndex = 0;
                    int secondIndex = 0;
                    int elementIndex = 0;
                    if (list.contains(commandParts[1]) && list.contains(commandParts[2])) {
                        for (int i = 0; i < list.size(); i++) {
                            if (commandParts[1].equals(list.get(i))) {
                                firstIndex = i;
                            } else if (commandParts[2].equals(list.get(i))) {
                                secondIndex = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            elementParts = list.get(i).split("-");
                            element = list.get(i);
                            if (1 < elementParts.length && elementParts[1].equals("Exercise")) {
                                if (list.contains(commandParts[2])) {
                                    for (int k = 0; k < list.size(); k++) {
                                        if (element.equals(list.get(k))) {
                                            firstIndex = k;
                                        } else if (commandParts[2].equals(list.get(k))) {
                                            secondIndex = k;
                                            elementIndex = k - 1;
                                        }
                                    }
                                } else if (list.contains(commandParts[1])) {
                                    for (int k = 0; k < list.size(); k++) {
                                        if (commandParts[1].equals(list.get(k))) {
                                            firstIndex = k;
                                            elementIndex = k - 1;
                                        } else if (element.equals(list.get(k))) {
                                            secondIndex = k;
                                        }
                                    }

                                }
                            }
                        }
                    }
                    Collections.swap(list, firstIndex, secondIndex);
                    if (1 < elementParts.length) {
                        list.add(elementIndex, elementParts[0]);
                    }
                    break;
                case "Exercise":
                    for (int i = 0; i < list.size(); i++) {
                        elementParts = list.get(i).split("-");
                    }
                    if (1 < elementParts.length && elementParts[1].equals("Exercise")) {
                        break;
                    } else if (list.contains(commandParts[1])) {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).equals(commandParts[1])) {
                                list.set(j, commandParts[1] + "-" + commandParts[0]);
                            }
                        }
                    } else {
                        list.add(commandParts[1] + "-" + commandParts[0]);
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, list.get(i));
        }
    }
}
