package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E04InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNum = Double.parseDouble(scanner.nextLine());
        double inchesToCentimeters = inputNum * 2.54;
        System.out.println(inchesToCentimeters);
    }
}
