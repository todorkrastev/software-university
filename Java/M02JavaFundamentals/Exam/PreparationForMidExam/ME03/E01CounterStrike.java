import java.util.Scanner;

public class E01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        int countBattles = 0;

        while (!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);

            if (initialEnergy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", countBattles, initialEnergy);
                return;
            } else {
                countBattles++;
                initialEnergy -= distance;
                if (countBattles % 3 == 0) {
                    initialEnergy += countBattles;
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d%n", countBattles, initialEnergy);
    }
}
