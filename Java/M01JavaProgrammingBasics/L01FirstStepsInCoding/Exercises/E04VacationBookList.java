package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E04VacationBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPagesCurrBook = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());

        int result = (numPagesCurrBook / pagesPerHour) / day;

        System.out.println(result);
    }
}
