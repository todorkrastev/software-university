package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E02WeekendOrWorkingDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDay = scanner.nextLine();

        switch (inputDay) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Working day");
                break;

            case "Saturday":
            case "Sunday":
                System.out.println("Weekend");
                break;

            default:
                System.out.println("Error");
                break;
        }
    }
}

