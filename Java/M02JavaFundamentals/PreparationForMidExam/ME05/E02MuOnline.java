import java.util.Scanner;

public class E02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;

        int currHealth = initialHealth;
        int bitcoin = 0;

        String[] commandParts = scanner.nextLine().split("\\|+");


        for (int i = 0; i < commandParts.length; i++) {
            String input = commandParts[i];
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];
            String number = inputParts[1];
            int bestRoom = i + 1;

            switch (command) {
                case "potion":
                    if (initialHealth < Integer.parseInt(number) + currHealth) {
                        int numberInt = initialHealth - currHealth;
                        currHealth = initialHealth;
                        System.out.printf("You healed for %d hp.%n", numberInt);
                    } else {
                        currHealth += Integer.parseInt(number);
                        System.out.printf("You healed for %s hp.%n", number);
                    }
                        System.out.printf("Current health: %s hp.%n", currHealth);
                    break;
                case "chest":
                    System.out.printf("You found %s bitcoins.%n", number);
                    bitcoin += Integer.parseInt(number);
                    break;
                default:
                    if (0 < currHealth - Integer.parseInt(number)) {
                        currHealth -= Integer.parseInt(number);
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", bestRoom);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoin);
        System.out.printf("Health: %d%n", currHealth);
    }
}
