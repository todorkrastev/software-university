package bg.softuni.programming_basics.nested_loops.lab;

import java.util.Scanner;

public class E06Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flour = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int i = flour; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (i == flour) {
                    System.out.printf("L%d%d ", i, j);
                } else if (i % 2 == 0) {
                    System.out.printf("O%d%d ", i, j);
                } else {
                    System.out.printf("A%d%d ", i, j);
                }
            }
            System.out.println();
        }
    }
}
