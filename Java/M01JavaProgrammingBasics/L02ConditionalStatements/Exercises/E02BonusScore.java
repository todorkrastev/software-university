package bg.softuni.programming_basics.conditional_statements.exercises;

import java.util.Scanner;

public class E02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Score = Integer.parseInt(scanner.nextLine());
        double bonus;

        if (Score <= 100) {
            bonus = 5;
        } else if (Score > 1000) {
            bonus = Score * 0.10;
        } else {
            bonus = Score * 0.2;
        }
        if (Score % 2 == 0) {
            bonus += 1;
        } else if (Score % 10 == 5) {
            bonus += 2;
        }
        System.out.println(bonus);
        System.out.println(Score + bonus);
    }
}
