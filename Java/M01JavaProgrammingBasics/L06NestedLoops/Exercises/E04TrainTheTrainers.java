package bg.softuni.programming_basics.nested_loops.exercises;

import java.util.Scanner;

public class E04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();

        double totalSum = 0;
        int count = 0;

        while (!text.equals("Finish")) {
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                double evaluation = Double.parseDouble(scanner.nextLine());
                sum += evaluation;
            }
            System.out.printf("%s - %.2f.%n", text, sum / n);
            count++;
            totalSum += sum;
            text = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalSum / (n * count));
    }
}
