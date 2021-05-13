package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E07WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timePerMeter = Double.parseDouble(scanner.nextLine());

        double delay = Math.floor(distance / 15) * 12.5;
        double time = distance * timePerMeter + delay;

        if (time < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", time - record);
        }
    }
}
