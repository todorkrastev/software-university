package bg.softuni.programming_basics.conditional_statements_advanced.exercises;

import java.util.Scanner;

public class E06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double sum;

        switch (operator) {
            case '+':
                sum = n1 + n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", n1, operator, n2, sum);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", n1, operator, n2, sum);
                }
                break;
            case '-':
                sum = n1 - n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", n1, operator, n2, sum);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", n1, operator, n2, sum);
                }
                break;
            case '*':
                sum = n1 * n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", n1, operator, n2, sum);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", n1, operator, n2, sum);
                }
                break;
            case '/':
                if (n2 > 0) {
                    sum = 1.0 * n1 / n2;
                    System.out.printf("%d %c %d = %.2f", n1, operator, n2, sum);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
            case '%':
                if (n2 > 0) {
                    sum = n1 % n2;
                    System.out.printf("%d %% %d = %.0f", n1, n2, sum);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
        }
    }
}
