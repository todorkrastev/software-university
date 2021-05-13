package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E08GraduationPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        double evaluateSum = 0.0;
        double evaluate = 0.0;

        for (int i = 1; i <= 12; i++) {
            evaluate = Double.parseDouble(scanner.nextLine());
            while (evaluate < 4) {
                evaluate = Double.parseDouble(scanner.nextLine());
                if (evaluate < 4) {
                    break;
                }
            }
            if (evaluate < 4) {
                System.out.printf("%s has been excluded at %d grade", name, i);
                break;
            }
            evaluateSum += evaluate;
        }
        if (evaluate >= 4) {
            System.out.printf("%s graduated. Average grade: %.2f", name, evaluateSum / 12);
        }
    }
}
