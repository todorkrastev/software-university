package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E03SquareArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sideTriangle = Integer.parseInt(scanner.nextLine());
        int squareTriangle = sideTriangle * sideTriangle;
        System.out.println(squareTriangle);
    }
}
