package bg.softuni.programming_basics.nested_loops.exercises;

import java.util.Scanner;

public class E01NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int numberForPrint = 1;

        for (int row = 1; row <= n; row++) {
            for (int numbersPerRow = 1; numbersPerRow <= row; numbersPerRow++) {
                System.out.printf("%d", numberForPrint);
                numberForPrint++;
                if (numberForPrint > n) {
                    break;
                }
            }
            System.out.println();
            if (numberForPrint > n) {
                break;
            }
        }
    }
}