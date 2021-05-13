package bg.softuni.programming_basics.for_loop.lab;

import java.util.Scanner;

public class E11CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        int toy = Integer.parseInt(scanner.nextLine());

        double money = 0.0;
        int a = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                a += 10;
                money += a - 1;
            } else {
                money += toy;
            }
        }
        if (money >= price) {
            System.out.printf("Yes! %.2f", money - price);
        } else {
            System.out.printf("No! %.2f", price - money);
        }
    }
}
