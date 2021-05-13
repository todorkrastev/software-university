package bg.softuni.programming_basics.for_loop.lab;

import java.util.Scanner;

public class E03Numbers1ToNWith3Steps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= a; i += 3) {
            System.out.println(i);
        }
    }
}
