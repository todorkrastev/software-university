package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double squareMeterPrice = 7.61;
        double discount = 0.18;

        double squareMeterGreening = Double.parseDouble(scanner.nextLine());

        double priceWithoutDiscount = squareMeterPrice * squareMeterGreening;
        double priceWithDiscount = priceWithoutDiscount * discount;
        double finalPrice = priceWithoutDiscount - priceWithDiscount;

        System.out.printf("The final price is: %g lv." , finalPrice);
        System.out.printf("The discount is: %g lv." , priceWithDiscount);
    }
}
