package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E08FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int heightCm = Integer.parseInt(scanner.nextLine());
        double procent = Double.parseDouble(scanner.nextLine());

        double volumeFishTank = ((lengthCm * widthCm * heightCm) * 0.001) ;
        procent *= 0.01;
        double litresNeeded = volumeFishTank * (1 - procent);

        System.out.printf("%.2f", litresNeeded);
    }
}
