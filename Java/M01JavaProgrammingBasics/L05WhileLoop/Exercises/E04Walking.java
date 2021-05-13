package bg.softuni.programming_basics.while_loop.exercises;

import java.util.Scanner;

public class E04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String steps;
        int leftSteps = 10000;
        int step;

        while (leftSteps > 0) {
            steps = scanner.nextLine();
            if (steps.equals("Going home")) {
                steps = scanner.nextLine();
                step = Integer.parseInt(steps);
                leftSteps -= step;
                if (leftSteps > 0) {
                    System.out.printf("%d more steps to reach goal.", leftSteps);
                }
                break;
            }
            step = Integer.parseInt(steps);
            leftSteps -= step;
        }
        if (leftSteps <= 0) {
            System.out.println("Goal reached! Good job!");
        }
    }
}
