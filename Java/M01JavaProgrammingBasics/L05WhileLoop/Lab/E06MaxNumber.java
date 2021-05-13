package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > max) {
                max = num;
            }
        }
        System.out.printf("%d", max);
    }
}
