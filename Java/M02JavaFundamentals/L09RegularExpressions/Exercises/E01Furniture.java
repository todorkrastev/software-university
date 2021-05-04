import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)");
        double totalMoneySpend = 0.0;
        List<String> list = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"Purchase".equals(command)) {
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                String furniture = matcher.group("furniture");
                String price = matcher.group("price");
                String quantity = matcher.group("quantity");

                list.add(furniture);

                double priceToDouble = Double.parseDouble(price);
                int quantityToInt = Integer.parseInt(quantity);

                totalMoneySpend += priceToDouble * quantityToInt;

            }

            command = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        list
                .forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalMoneySpend);
    }
}
