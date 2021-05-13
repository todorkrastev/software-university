package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E05PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String insertPassword = scanner.nextLine();
        if (insertPassword.equals("s3cr3t!P@ssw0rd"))
        {
            System.out.println("Welcome");
        }
        else
        {
            System.out.println("Wrong password!");
        }
    }
}
