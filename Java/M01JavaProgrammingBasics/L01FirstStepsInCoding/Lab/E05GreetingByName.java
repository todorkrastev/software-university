package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E05GreetingByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        System.out.printf("Hello, %s!", inputName);
    }
}
