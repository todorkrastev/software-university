package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogsNum = Integer.parseInt(scanner.nextLine());
        int otherAnimalsNum = Integer.parseInt(scanner.nextLine());

        double dogFoodPrice = 2.5;
        double otherAnimalsPrice = 4;

        double result = dogsNum * dogFoodPrice + otherAnimalsNum * otherAnimalsPrice;

        System.out.println(result);
    }
}
