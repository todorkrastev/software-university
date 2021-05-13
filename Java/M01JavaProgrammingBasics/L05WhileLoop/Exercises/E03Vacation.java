package bg.softuni.programming_basics.while_loop.exercises;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String typePlace;
        String location;
        double price;

        if (budget <= 1000) {
            typePlace = "Camp";
            location = season.equals("Summer") ? "Alaska" : "Morocco";
            price = season.equals("Summer") ? budget * 0.65 : budget * 0.45;
        } else if (budget <= 3000) {
            typePlace = "Hut";
            location = season.equals("Summer") ? "Alaska" : "Morocco";
            price = season.equals("Summer") ? budget * 0.8 : budget * 0.6;
        } else {
            typePlace = "Hotel";
            price = budget * 0.9;
            location = season.equals("Summer") ? "Alaska" : "Morocco";
        }
        System.out.printf("%s - %s - %.2f", location, typePlace, price);
    }
}
