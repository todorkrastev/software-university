package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositAmount = Double.parseDouble(scanner.nextLine());
        int depositMonths = Integer.parseInt(scanner.nextLine());
        double annualInterest = Double.parseDouble(scanner.nextLine());

        double currInterest =(depositAmount * annualInterest / 100) / 12;
        double result = depositAmount + (depositMonths * currInterest);

        System.out.println(result);
    }
}
