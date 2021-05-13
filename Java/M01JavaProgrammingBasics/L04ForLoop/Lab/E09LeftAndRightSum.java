package bg.softuni.programming_basics.for_loop.lab;

import java.util.Scanner;

public class E09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int leftSum = 0;
        int rightSum = 0;
        for (int left = 1; left <= n; left++) {
            leftSum += scanner.nextInt();
        }
        for (int right = 1; right <= n; right++) {
            rightSum += scanner.nextInt();
        }
        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(leftSum - rightSum));
        }
    }
}
