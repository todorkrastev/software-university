package E04ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02FancyBarcodes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();

            String regEx = "@#+(?<barcode>[A-Z][a-zA-Z0-9]{4,}[A-Z])@#+";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");

                for (int j = 0; j < barcode.length(); j++) {
                    char currSymbol = barcode.charAt(j);

                    if (Character.isDigit(currSymbol)) {
                        stringBuilder.append(currSymbol);
                    }
                }
                if (stringBuilder.toString().isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", stringBuilder.toString());
                }

            } else {
                System.out.println("Invalid barcode");
            }
            stringBuilder.setLength(0);
        }
    }
}