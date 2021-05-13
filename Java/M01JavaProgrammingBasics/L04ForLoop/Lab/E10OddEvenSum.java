package bg.softuni.programming_basics.for_loop.lab;

import java.util.Scanner;

public class E10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }
        if (even == odd) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", even);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(even - odd));
        }
    }
}
