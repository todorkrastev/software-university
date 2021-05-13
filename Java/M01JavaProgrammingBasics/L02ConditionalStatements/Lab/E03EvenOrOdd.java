package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E03EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int insertNumber = Integer.parseInt(scanner.nextLine());
        if (insertNumber % 2 == 0)
        {
            System.out.println("even");
        }
        else
        {
            System.out.println("odd");
        }
    }
}
