package bg.softuni.programming_basics.conditional_statements_advanced.exercises;

import java.util.Scanner;

public class E07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double apartment = 0;
        double studio = 0;

        switch (month) {
            case "May":
            case "October":
                apartment = 65.0 * days;
                studio = 50.0 * days;
                break;
            case "June":
            case "September":
                apartment = 68.70 * days;
                studio = 75.20 * days;
                break;
            case "July":
            case "August":
                apartment = 77.0 * days;
                studio = 76.0 * days;
                break;
        }
        if (days > 14) {
            apartment *= 0.9;
        }
        if (days > 14 && month.equals("June") || month.equals("September")) {
            studio *= 0.8;
        }
        if (month.equals("May") || month.equals("October")) {
            if (days > 14) {
                studio *= 0.70;
            } else if (days > 7) {
                studio *= 0.95;
            }
        }
        System.out.printf("Apartment: %.2f lv.%n", apartment);
        System.out.printf("Studio: %.2f lv.", studio);
    }
}
