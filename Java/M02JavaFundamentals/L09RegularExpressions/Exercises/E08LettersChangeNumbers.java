import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().trim().split("\\s+");

        double sum = 0.0;

        for (String combination : array) {

            double result = 0.0;

            char firstChar = combination.charAt(0);
            char lastChar = combination.charAt(combination.length() - 1);
            long number = Long.parseLong(combination.substring(1, Integer.parseInt(String.valueOf(combination.length() - 1))));

            if (Character.isUpperCase(firstChar)) {
                result = (double) number / (firstChar - 64);
            } else if (Character.isLowerCase(firstChar)) {
                result = number * (firstChar - 96);
            }
            if (Character.isUpperCase(lastChar)) {
                result -= lastChar - 64;
            } else if (Character.isLowerCase(lastChar)) {
                result += lastChar - 96;
            }
            sum += result;
        }
        System.out.printf("%.2f", sum);
    }
}