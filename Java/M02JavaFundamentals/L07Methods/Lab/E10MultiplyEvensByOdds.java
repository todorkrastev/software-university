import java.util.InputMismatchException;
import java.util.Scanner;

public class E10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultiplyOfEvensandOdds(input));

    }

    public static int getMultiplyOfEvensandOdds(int input) {
        int evenSum = getSumOfEvens(Math.abs(input));
        int oddSum = getSumOfOdds(Math.abs(input));
        return evenSum * oddSum;
    }

    public static int getSumOfEvens(int input) {
        int sumInput = 0;
        while (input > 0) {
            int digit = input % 10;
            if (digit % 2 == 0) {
                sumInput += digit;
            }
            input /= 10;
        }
        return sumInput;
    }

    public static int getSumOfOdds(int input) {
        int sumInput = 0;
        while (input > 0) {
            int digit = input % 10;
            if (digit % 2 == 1) {
                sumInput += digit;
            }
            input /= 10;
        }
        return sumInput;
    }
}
