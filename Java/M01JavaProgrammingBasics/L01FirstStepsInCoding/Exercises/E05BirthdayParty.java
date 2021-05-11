package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E05BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rentOfHall = Integer.parseInt(scanner.nextLine());

        double cakePrice = rentOfHall * 0.2;
        double beveragesPrice = cakePrice * 0.55;
        double entertainer = rentOfHall * 1.0 / 3;

        double result = rentOfHall + cakePrice + beveragesPrice + entertainer;

        System.out.println(result);
    }
}
