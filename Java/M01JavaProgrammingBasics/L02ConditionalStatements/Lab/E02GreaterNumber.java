package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E02GreaterNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        System.out.println(Math.max(firstNum, secondNum));
    }
}
