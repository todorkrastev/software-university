package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        if (hour >= 10 && hour <= 18 && !dayOfWeek.equals("Sunday"))

            switch (dayOfWeek)
            {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                case "Saturday":
                    System.out.println("open");
                    break;
            }
        else
        {
            System.out.println("closed");
        }
    }
}
