package bg.softuni.java_oop.exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P01_SquareRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();

        try {
            double number = Double.parseDouble(input);
            double mathSqRt = isNumberEqualOrMoreThanZero(number);
            System.out.println(mathSqRt);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid number : " + input);
        } finally {
            System.out.println("Good bye");
        }
    }

    private static double isNumberEqualOrMoreThanZero(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Square root for negative numbers is undefined");
        }
        return Math.sqrt(num);
    }
}
