package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E06ConcatenateData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String familyName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String homeTown = scanner.nextLine();
        System.out.printf("You are %s %s, a %d-years old person from %s.", firstName,familyName,age,homeTown);
    }
}
