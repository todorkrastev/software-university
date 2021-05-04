import java.util.Scanner;

public class E05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        double price = 0.0;
        int quantity = Integer.parseInt(scanner.nextLine());

        order(text, quantity, price);
    }

    public static void order(String text, int quantity, double price) {
        price = 0.0;
        switch (text) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
            default:
                break;
        }
        double result = price * quantity;
        System.out.printf("%.2f%n", result);;
    }
}
