package bg.softuni.programming_basics.first_steps_in_coding.exercises;

import java.util.Scanner;

public class E06CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysCampaign = Integer.parseInt(scanner.nextLine());
        int bakersNum = Integer.parseInt(scanner.nextLine());
        int cakesNum = Integer.parseInt(scanner.nextLine());
        int wafflesNum = Integer.parseInt(scanner.nextLine());
        int pancakesNum = Integer.parseInt(scanner.nextLine());

        double cakePrice = 45;
        double wafflePrice = 5.80;
        double pancakesPrice = 3.20;

        double result = ((((cakePrice * cakesNum + wafflesNum * wafflePrice + pancakesPrice * pancakesNum) * bakersNum) * daysCampaign) * 0.875);
        System.out.printf("%.2f", result);
    }
}
