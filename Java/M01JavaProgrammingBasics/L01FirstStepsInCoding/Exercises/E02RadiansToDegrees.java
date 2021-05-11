package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E02RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radian = Double.parseDouble(scanner.nextLine());
        double radiansToDegrees = radian * 180 / Math.PI;

        System.out.printf("%.0f", radiansToDegrees);
    }
}
