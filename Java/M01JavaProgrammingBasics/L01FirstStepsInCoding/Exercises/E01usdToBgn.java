package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E01usdToBgn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        double USDtoBGN = input * 1.79549;

        System.out.println(USDtoBGN);
    }
}
