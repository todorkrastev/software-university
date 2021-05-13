package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E04Number100to200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int insertNumber = Integer.parseInt(scanner.nextLine());
        if (insertNumber <= 99)
        {
            System.out.println("Less than 100");
        }
        else if (insertNumber <= 200)
        {
            System.out.println("Between 100 and 200");
        }
        else
        {
            System.out.println("Greater than 200");
        }
    }
}
