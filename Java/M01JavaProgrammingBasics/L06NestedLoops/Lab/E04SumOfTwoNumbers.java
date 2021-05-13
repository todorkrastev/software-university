package bg.softuni.programming_basics.nested_loops.lab;

import java.util.Scanner;

public class E04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());

        int sum;
        int count = 0;
        int i, j;

        for (i = a; i <= b; i++) {
            for (j = a; j <= b; j++) {
                sum = i + j;
                count++;
                if (sum == num) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, num);
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                break;
            }
        }
        if (i > 0) {
            System.out.printf("%d combinations - neither equals %d", count, num);
        }
    }
}
