package bg.softuni.programming_basics.for_loop.exercises;

import java.util.Scanner;

public class E02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int bigger = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(scanner.nextLine());
            sum = sum + a;
            if (a > bigger) {
                bigger = a;
            }
        }
        if (1.0 * sum / 2 == bigger) {
            System.out.println("Yes");
            System.out.println("Sum = " + bigger);
        } else {
            System.out.println("No");
            int diff = Math.abs(bigger - (sum - bigger));
            System.out.println("Diff = " + diff);
        }
    }
}
