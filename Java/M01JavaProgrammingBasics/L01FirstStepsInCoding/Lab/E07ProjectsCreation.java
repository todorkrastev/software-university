package bg.softuni.programming_basics.first_steps_in_coding.lab;

import java.util.Scanner;

public class E07ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameArchitecture = scanner.nextLine();
        int projectsNum = Integer.parseInt(scanner.nextLine());

        int projectCreation = 3;

        int result = projectCreation * projectsNum;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", nameArchitecture, result, projectsNum);
    }
}
