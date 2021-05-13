package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        String prPeriod;
        double price = 0.0;
        if (day.equals("Saturday") || day.equals("Sunday")) {
            prPeriod = "weekend";
        } else if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
            prPeriod = "week";
        } else {
            prPeriod = "error";
        }
        switch (prPeriod) {
            case "week":
                switch (fruit) {
                    case "banana":
                        price += 2.5;
                        break;
                    case "apple":
                        price += 1.2;
                        break;
                    case "orange":
                        price += 0.85;
                        break;
                    case "grapefruit":
                        price += 1.45;
                        break;
                    case "kiwi":
                        price += 2.7;
                        break;
                    case "pineapple":
                        price += 5.5;
                        break;
                    case "grapes":
                        price += 3.85;
                        break;
                    default:
                        price = 0.0;
                }
                break;
            case "weekend":
                switch (fruit) {
                    case "banana":
                        price += 2.7;
                        break;
                    case "apple":
                        price += 1.25;
                        break;
                    case "orange":
                        price += 0.9;
                        break;
                    case "grapefruit":
                        price += 1.6;
                        break;
                    case "kiwi":
                        price += 3.0;
                        break;
                    case "pineapple":
                        price += 5.6;
                        break;
                    case "grapes":
                        price += 4.2;
                        break;
                    default:
                        price = 0.0;
                }
                break;
            case "error":
                price = 0.0;
                break;
        }
        if (price > 0) {
            System.out.printf("%.2f", price * quantity);
        } else {
            System.out.println("error");
        }
    }
}
