import java.util.Scanner;

public class E01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double price;

        double sum = 0;

        while (!"regular".equals(command) && !"special".equals(command)) {
            price = Double.parseDouble(command);
            if (price <= 0) {
                System.out.println("Invalid price!");
            } else {
                sum += price;
            }
            command = scanner.nextLine();
        }
        double priceVAT = sum * 1.2;
        if ("special".equals(command)) {
            double discount;
            discount = priceVAT * 0.9;
            if (discount <= 0) {
                System.out.println("Invalid order!");
            } else {
                System.out.printf("Congratulations you've just bought a new computer!%n" +
                        "Price without taxes: %.2f$%n" +
                        "Taxes: %.2f$%n" +
                        "-----------%n" +
                        "Total price: %.2f$", sum, priceVAT - sum, discount);
            }
        } else {
            if (priceVAT <= 0) {
                System.out.println("Invalid order!");

            } else {
                System.out.printf("Congratulations you've just bought a new computer!%n" +
                        "Price without taxes: %.2f$%n" +
                        "Taxes: %.2f$%n" +
                        "-----------%n" +
                        "Total price: %.2f$", sum, priceVAT - sum, priceVAT);
            }
        }
    }
}
