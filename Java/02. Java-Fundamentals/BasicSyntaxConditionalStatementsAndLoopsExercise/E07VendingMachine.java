import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double inputMoney = 0.0;
        double sum = 0.0;
        double price = 0.0;
        String purchasedProduct = "";

        while (!command.equals("Start")) {
            inputMoney = Double.parseDouble(command);
            if (inputMoney != 0.1 && inputMoney != 0.2 && inputMoney != 0.5 && inputMoney != 1.0 && inputMoney != 2.0) {
                System.out.printf("Cannot accept %.2f%n", inputMoney);
                inputMoney = 0;
            }
            sum += inputMoney;
            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "Nuts":
                    price = 2.0;
                    purchasedProduct = "Nuts";
                    break;
                case "Water":
                    price = 0.7;
                    purchasedProduct = "Water";
                    break;
                case "Crisps":
                    price = 1.5;
                    purchasedProduct = "Crisps";
                    break;
                case "Soda":
                    price = 0.8;
                    purchasedProduct = "Soda";
                    break;
                case "Coke":
                    price = 1.0;
                    purchasedProduct = "Coke";
                    break;
                default:
                    System.out.println("Invalid product");
                    command = scanner.nextLine();
                    continue;
            }
            if (sum < price) {
                System.out.println("Sorry, not enough money");
                sum += price;
            } else if (price <= sum) {
                System.out.printf("Purchased %s%n", purchasedProduct);
            }
            sum -= price;
            command = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
