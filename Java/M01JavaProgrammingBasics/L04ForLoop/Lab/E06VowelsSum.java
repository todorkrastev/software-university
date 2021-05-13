package bg.softuni.programming_basics.for_loop.lab;

import java.util.Scanner;

public class E06VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int sum = 0;

        for (int q = 0; q < text.length(); q++) {

            char symbol = text.charAt(q);
            if (symbol == ('a')) {
                sum += 1;
            } else if (symbol == ('e')) {
                sum += 2;
            } else if (symbol == ('i')) {
                sum += 3;
            } else if (symbol == ('o')) {
                sum += 4;
            } else if (symbol == ('u')) {
                sum += 5;
            }
        }
        System.out.println(sum);
    }
}
