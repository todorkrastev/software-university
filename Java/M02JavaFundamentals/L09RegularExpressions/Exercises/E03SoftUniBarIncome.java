import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%([^|$%.]*)<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+)\\$");

        String command = scanner.nextLine();

        double totalIncome = 0.0;

        while (!"end of shift".equals(command)) {
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                String count = matcher.group("count");
                String price = matcher.group("price");

                int countToInt = Integer.parseInt(count);
                double priceToDouble = Double.parseDouble(price);

                double totalPrice = countToInt * priceToDouble;

                totalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);

            }
            command = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}