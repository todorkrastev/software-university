import java.util.Scanner;

public class E02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        grade(Double.parseDouble(scanner.nextLine()));
    }

    public static void grade(double input) {
        String gradeInWords = "";
        if (2 <= input && input <= 2.99) {
            gradeInWords = "Fail";
        } else if (3 <= input && input <= 3.49) {
            gradeInWords = "Poor";
        } else if (3.5 <= input && input <= 4.49) {
            gradeInWords = "Good";
        } else if (4.5 <= input && input <= 5.49) {
            gradeInWords = "Very good";
        } else if (5.5 <= input && input <= 6) {
            gradeInWords = "Excellent";
        }
        System.out.println(gradeInWords);
    }
}

