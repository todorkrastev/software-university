import java.util.Scanner;

public class E03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double price = 0.0;
        double totalSpent = 0.0;

        while (!command.equals("Game Time")){
            switch (command){
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    command = scanner.nextLine();
                    continue;
            }
            if (currentBalance < price){
                System.out.println("Too Expensive");
                command = scanner.nextLine();
                continue;
            }
            currentBalance -= price;
            if (currentBalance <= 0){
                System.out.println("Out of mo-ney");
                return;
            }
            totalSpent += price;
            System.out.printf("Bought %s%n", command);
            command = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
    }
}
