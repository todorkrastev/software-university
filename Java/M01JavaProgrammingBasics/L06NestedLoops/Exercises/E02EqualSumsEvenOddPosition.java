package bg.softuni.programming_basics.nested_loops.exercises;

import java.util.Scanner;

public class E02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int n1 = Integer.parseInt(scanner.nextLine());

        int sumOdd = 0;
        int sumEven = 0;
        for (int i = n; i <= n1; i++) {
            for (int j = 0; j <= 5; j++) {
                int num = Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
                if (j % 2 == 0) {
                    sumOdd += num;
                } else {
                    sumEven += num;
                }
            }
            if (sumEven == sumOdd) {
                System.out.print(i + " ");
            }
            sumEven = 0;
            sumOdd = 0;
        }
    }
}
