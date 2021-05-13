package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int count = 0;

        while (!text.equals("Stop")) {
            text = scanner.nextLine();
            count++;
        }
        System.out.printf("%d", count);
    }
}
