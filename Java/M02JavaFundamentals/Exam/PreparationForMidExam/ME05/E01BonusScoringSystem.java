import java.util.Scanner;

public class E01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte countOfStudents = Byte.parseByte(scanner.nextLine());
        byte countOfLectures = Byte.parseByte(scanner.nextLine());
        byte initialBonus = Byte.parseByte(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int currAtt = 0;

        for (int i = 0; i < countOfStudents; i++) {
            int countOfAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = Math.round((double) countOfAttendances / countOfLectures * (5 + initialBonus));
            if (maxValue < totalBonus) {
                currAtt = countOfAttendances;
                maxValue = totalBonus;
            }
        }
        System.out.printf("Max Bonus: %d.%n", (int) maxValue);
        System.out.printf("The student has attended %d lectures.%n", currAtt);
    }
}
