package bg.softuni.programming_basics.while_loop.exercises;

import java.util.Scanner;

public class E01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String book = scanner.nextLine();
            if (book.equals(text)) {
                System.out.printf("You checked %d books and found it.", i - 1);
                break;
            } else if (i == n) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", i);
                break;
            }
        }
    }
}
