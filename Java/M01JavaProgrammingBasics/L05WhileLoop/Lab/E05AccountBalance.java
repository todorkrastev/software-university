package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            if (input < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", input);
                sum += input;
            }
        }
        System.out.printf("Total: %.2f", sum);
    }
}
