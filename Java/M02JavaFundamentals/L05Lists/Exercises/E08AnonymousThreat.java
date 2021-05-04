import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] commandParts = command.split("\\s+");

            switch (commandParts[0]) {
                case "merge":

                    int startIndex = Math.max(Integer.parseInt(commandParts[1]), 0);
                    int endIndex = Math.min(Integer.parseInt(commandParts[2]), list.size() - 1);

                    for (int i = startIndex; i < endIndex; i++) {
                        String concat = list.get(startIndex) + list.get(startIndex + 1);
                        list.set(startIndex, concat);
                        list.remove(startIndex + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commandParts[1]);
                    int partitions = Integer.parseInt(commandParts[2]);

                    if (index >= 0 && index < list.size() && partitions >= 0 && partitions <= 100) {
                        String element = list.get(index);
                        List<String> newList = new ArrayList<>();

                        int portionLength = element.length() / partitions;
                        int count = 0;
                        if (element.length() % partitions == 0) {
                            for (int i = 0; i < partitions; i++) {
                                StringBuilder concat = new StringBuilder();
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat.append(symbol);
                                    count++;
                                }
                                newList.add(concat.toString());
                            }
                        } else {
                            for (int i = 0; i < partitions; i++) {
                                StringBuilder concat = new StringBuilder();

                                if (i == partitions - 1) {
                                    for (int j = count; j < element.length(); j++) {
                                        char symbol = element.charAt(count);
                                        concat.append(symbol);
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat.append(symbol);
                                        count++;
                                    }
                                }
                                newList.add(concat.toString());
                            }
                        }
                        list.remove(index);
                        list.addAll(index, newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (String item : list) {
            System.out.print(item + " ");
        }
    }
}