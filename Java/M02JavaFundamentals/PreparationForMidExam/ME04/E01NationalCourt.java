import java.util.Scanner;

public class E01NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int totalPeople = Integer.parseInt(scanner.nextLine());

        int countHours = 0;

        int totalEmployee = firstEmployee + secondEmployee + thirdEmployee;

        while (0 < totalPeople) {
            totalPeople -= totalEmployee;
            countHours++;
            if (countHours % 4 == 0) {
                countHours++;
            }
        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
