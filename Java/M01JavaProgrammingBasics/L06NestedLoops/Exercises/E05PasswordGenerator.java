package bg.softuni.programming_basics.nested_loops.exercises;

import java.util.Scanner;

public class E05PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 97; k <= 96 + l; k++) {
                    for (int m = 97; m <= 96 + l; m++) {
                        for (int h = 2; h <= n; h++) {
                            if (h > i && h > j) {
                                char a = (char) k;
                                char b = (char) m;
                                System.out.printf("%d%d%c%c%d ", i, j, a, b, h);
                            }
                        }
                    }
                }
            }
        }
    }
}
