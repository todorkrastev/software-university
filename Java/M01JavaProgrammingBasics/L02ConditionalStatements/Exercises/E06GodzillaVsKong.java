package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E06GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int actors = Integer.parseInt(scanner.nextLine());
        double priceCostum = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        if (actors > 150) {
            priceCostum *= 0.9;
        }
        double total = (priceCostum * actors) + decor;
        if (total > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", total - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - total);
        }
    }
}
