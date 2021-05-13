package bg.softuni.programming_basics.nested_loops.lab;

import java.util.Scanner;

public class E05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        double budget;
        double money = 0;

        while (!destination.equals("End")) {
            budget = Double.parseDouble(scanner.nextLine());
            while (money < budget) {
                money = Double.parseDouble(scanner.nextLine());
                budget -= money;
                money = 0;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
