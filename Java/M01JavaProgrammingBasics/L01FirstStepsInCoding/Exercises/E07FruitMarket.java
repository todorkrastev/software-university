package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E07FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberriesPrice = Double.parseDouble(scanner.nextLine());
        double bananasQuantity = Double.parseDouble(scanner.nextLine());
        double orangesQuantity = Double.parseDouble(scanner.nextLine());
        double raspberriesQuantity = Double.parseDouble(scanner.nextLine());
        double strawberriesQuantity = Double.parseDouble(scanner.nextLine());

        double raspberriesPrice = strawberriesPrice * 0.5;
        double orangesPrice = raspberriesPrice * 0.6;
        double bananasPrice = raspberriesPrice * 0.2;

        double result = strawberriesPrice * strawberriesQuantity + bananasPrice * bananasQuantity + orangesPrice * orangesQuantity + raspberriesPrice * raspberriesQuantity;

        System.out.printf("%.2f", result);
    }
}
