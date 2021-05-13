package bg.softuni.programming_basics.while_loop.exercises;

import java.util.Scanner;

public class E06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int total = a * b;
        for (; ; ) {
            String n = scanner.nextLine();
            if (n.equals("STOP")) {
                System.out.printf("%d pieces are left.", total);
                break;
            } else {
                int left = Integer.parseInt(n);
                total -= left;
                if (total <= 0) {
                    System.out.printf("No more cake left! You need %d pieces more.", Math.abs(total));
                    break;
                }
            }
        }
    }
}
