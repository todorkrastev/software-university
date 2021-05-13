package bg.softuni.programming_basics.conditional_statements_advanced.exercises;

import java.util.Scanner;

public class E09VolleyBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        int holiday = Integer.parseInt(scanner.nextLine());
        int weekend = Integer.parseInt(scanner.nextLine());

        double games = ((48.0 - weekend) * (3.0 / 4) + weekend + (holiday * (2.0 / 3)));

        if (year.equals("leap")) {
            games *= 1.15;
        }
        System.out.printf("%.0f", Math.floor(games));
    }
}
