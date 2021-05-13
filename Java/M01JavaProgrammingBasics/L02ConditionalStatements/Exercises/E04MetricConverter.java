package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E04MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String exit = scanner.nextLine();

        if (input.equals("m") && exit.equals("cm")) {
            System.out.printf("%.3f", num * 100);
        } else if (input.equals("m") && exit.equals("mm")) {
            System.out.printf("%.3f", num * 1000);
        } else if (input.equals("cm") && exit.equals("m")) {
            System.out.printf("%.3f", num / 100);
        } else if (input.equals("cm") && exit.equals("mm")) {
            System.out.printf("%.3f", num * 10);
        } else if (input.equals("mm") && exit.equals("m")) {
            System.out.printf("%.3f", num / 1000);
        } else if (input.equals("mm") && exit.equals("cm")) {
            System.out.printf("%.3f", num / 10);
        }
    }
}
