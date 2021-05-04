import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+", 2);

            if ("is not going!".equals(command[1])) {
                if (list.contains(command[0])) {
                    list.remove(command[0]);
                } else {
                    System.out.printf("%s is not in the list!%n", command[0]);
                }
            } else if ("is going!".equals(command[1])) {
                if (list.contains(command[0])) {
                    System.out.printf("%s is already in the list!%n", command[0]);
                } else {
                    list.add(command[0]);
                }
            }
        }
        for (String s : list) {
            System.out.println(s + " ");
        }
    }
}

