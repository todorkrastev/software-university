import java.util.Scanner;

public class E04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int convertHourToMinutes = hour * 60;
        int extraMinutes = 30;

        int sum = convertHourToMinutes + extraMinutes + minutes;

        int sumHours = sum / 60;
        int sumMinutes = sum % 60;

        if (24 <= sumHours){
            sumHours -= 24;
        }

        System.out.printf("%d:%02d", sumHours, sumMinutes);
    }
}
