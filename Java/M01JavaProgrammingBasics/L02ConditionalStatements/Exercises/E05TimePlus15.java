package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E05TimePlus15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minute = Integer.parseInt(scanner.nextLine());

        hour *= 60;
        int additionalTime = 15;
        int totalTime = minute + hour + additionalTime;
        int finalHour = totalTime / 60;
        int finalMinutes = totalTime % 60;

        if (finalHour >= 24) {
            finalHour = 0;
        }
        System.out.printf("%d:%02d", finalHour, finalMinutes);
    }
}
