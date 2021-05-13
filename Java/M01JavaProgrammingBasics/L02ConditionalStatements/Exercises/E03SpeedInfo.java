package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E03SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double Speed = Double.parseDouble(scanner.nextLine());

        if (Speed <= 10) {
            System.out.println("slow");
        } else if (Speed <= 50) {
            System.out.println("average");
        } else if (Speed <= 150) {
            System.out.println("fast");
        } else if (Speed <= 1000) {
            System.out.println("ultra fast");
        } else
            System.out.println("extremely fast");
    }
}
