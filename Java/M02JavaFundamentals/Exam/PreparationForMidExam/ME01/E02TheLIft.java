import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02TheLIft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (people < 1) {
                break;
            }
            while (list.get(i) < 4) {
                if (people < 1) {
                    break;
                } else {
                    list.set(i, list.get(i) + 1);
                    people--;
                }
            }
        }
        if (people < 1) {
            System.out.println("The lift has empty spots!");
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
