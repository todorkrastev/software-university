package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E07MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < min) {
                min = num;
            }
        }
        System.out.printf("%d", min);
    }
}
