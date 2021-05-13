package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E07ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerTrip = Double.parseDouble(scanner.nextLine());
        int countPuzzle = Integer.parseInt(scanner.nextLine());
        int countDolls = Integer.parseInt(scanner.nextLine());
        int countBeers = Integer.parseInt(scanner.nextLine());
        int countMinions = Integer.parseInt(scanner.nextLine());
        int countTrucks = Integer.parseInt(scanner.nextLine());

        double profit = (countPuzzle * 2.60) + (countDolls * 3) + (countBeers * 4.10) + (countMinions * 8.20) + (countTrucks * 2);
        int countToys = countPuzzle + countDolls + countBeers + countMinions + countTrucks;

        if (countToys >= 50) {
            profit = profit - profit * 0.25;
        }
        double totalProfit = profit - profit * 0.1;

        if (totalProfit >= pricePerTrip) {
            double leftMoney = totalProfit - pricePerTrip;
            System.out.printf("Yes! %.2f lv left.", leftMoney);
        } else {
            double notEnoughMoney = pricePerTrip - totalProfit;
            System.out.printf("Not enough money! %.2f lv needed.", notEnoughMoney);
        }
    }
}
