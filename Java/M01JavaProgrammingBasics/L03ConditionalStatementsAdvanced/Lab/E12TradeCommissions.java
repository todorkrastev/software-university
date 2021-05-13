package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        if (sales < 0) {
            System.out.println("error");
        } else if (town.equals("Sofia") || town.equals("Varna") || town.equals("Plovdiv")) {
            switch (town) {
                case "Sofia":
                    if (sales <= 500 && sales >= 0) {
                        sales *= 0.05;
                    } else if (sales > 500 && sales <= 1000) {
                        sales *= 0.07;
                    } else if (sales > 1000 && sales <= 10000) {
                        sales *= 0.08;
                    } else if (sales > 10000) {
                        sales *= 0.12;
                    }
                    break;
                case "Varna":
                    if (sales <= 500 && sales >= 0) {
                        sales *= 0.045;
                    } else if (sales > 500 && sales <= 1000) {
                        sales *= 0.075;
                    } else if (sales > 1000 && sales <= 10000) {
                        sales *= 0.1;
                    } else if (sales > 10000) {
                        sales *= 0.13;
                    }
                    break;
                case "Plovdiv":
                    if (sales <= 500 && sales >= 0) {
                        sales *= 0.055;
                    } else if (sales > 500 && sales <= 1000) {
                        sales *= 0.08;
                    } else if (sales > 1000 && sales <= 10000) {
                        sales *= 0.12;
                    } else if (sales > 10000) {
                        sales *= 0.145;
                    }
                    break;
            }
            System.out.printf("%.2f", sales);
        } else {
            System.out.println("error");
        }
    }
}
