package bg.softuni.programming_basics.conditional_statements_advanced.exercises;

import java.util.Scanner;

public class E01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double premiere = 12.00;
        double normal = 7.50;
        double discount = 5.00;
        double income = 0.0;
        switch (projection) {
            case "Premiere":
                income = rows * columns * premiere;
                break;
            case "Normal":
                income = rows * columns * normal;
                break;
            case "Discount":
                income = rows * columns * discount;
                break;
        }
        System.out.printf("%.2f", income);
    }
}
