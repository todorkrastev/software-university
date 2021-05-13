package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if (num < 100 || num > 200) {
            if (num != 0) {

                System.out.println("invalid");
            }
        }
    }
}
