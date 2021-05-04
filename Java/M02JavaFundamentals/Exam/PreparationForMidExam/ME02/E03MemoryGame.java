import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().trim().split("\\s+");
        String firstCommand = command[0];

        int count = 0;

        while (!"end".equals(firstCommand)) {
            int firstIndex = Integer.parseInt(command[0]);
            int secondIndex = Integer.parseInt(command[1]);

            if (firstIndex == secondIndex || !(0 <= firstIndex && firstIndex < list.size()) || !(0 <= secondIndex && secondIndex < list.size())) {
                count++;
                String addIndex = "-" + count + "a";
                list.add(list.size() / 2, addIndex);
                list.add(list.size() / 2, addIndex);
                System.out.printf("Invalid input! Adding additional elements to the board%n");
            } else if (list.get(firstIndex).equals(list.get(secondIndex)) && firstIndex < secondIndex) {
                count++;
                System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(secondIndex));
                list.remove(secondIndex);
                list.remove(firstIndex);
            } else if (list.get(firstIndex).equals(list.get(secondIndex)) && secondIndex < firstIndex) {
                count++;
                System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(secondIndex));
                list.remove(firstIndex);
                list.remove(secondIndex);
            } else if (!list.get(firstIndex).equals(list.get(secondIndex))) {
                System.out.println("Try again!");
            }

            if (list.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", count);
                break;
            }
            command = scanner.nextLine().trim().split("\\s+");
            firstCommand = command[0];
        }
        if (!(list.isEmpty())) {
            System.out.printf("Sorry you lose :(%n");
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
