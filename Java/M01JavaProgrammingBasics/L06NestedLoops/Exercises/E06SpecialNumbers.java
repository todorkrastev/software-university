package bg.softuni.programming_basics.nested_loops.exercises;

import java.util.Scanner;

public class E06SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int count = 0;

        for (int i = 1111; i <= 9999; i++) {
            for (int j = 0; j <= 3; j++) {
                int num = Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
                if (num == 0) {
                    break;
                } else if (n % num == 0) {
                    count++;
                }
            }
            if (count == 4) {
                System.out.printf("%d ", i);
            }
            count = 0;
        }
    }
}
