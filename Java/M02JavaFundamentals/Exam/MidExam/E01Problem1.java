import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class E01Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfExperience = Integer.parseInt(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());
        double gainedExperience = 0;

        for (int i = 1; i <= countOfBattles; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (i % 3 != 0 && i % 5 != 0 && i % 15 != 0) {
                gainedExperience += input;
            }
            if (i % 3 == 0) {
                gainedExperience += input * 1.15;
            }
            if (i % 5 == 0) {
                gainedExperience += input * 0.9;
            }
            if (i % 15 == 0) {
                gainedExperience += input * 1.05;
            }

            if (amountOfExperience <= gainedExperience) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                return;
            }
        }
        if (gainedExperience < amountOfExperience) {
            double diff = amountOfExperience - gainedExperience;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", diff);
        }
    }
}
