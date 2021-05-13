package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String pass = scanner.nextLine();
        String newPass = scanner.nextLine();

        while (!newPass.equals(pass)) {
            newPass = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", user);
    }
}
