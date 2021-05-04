import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E05Hex2Dec {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String number = reader.readLine();
        int magnitude = 1;
        int sum = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            char currSymbol = number.charAt(i);
            int digit = 0;
            if (Character.isLetter(currSymbol)) {
                digit = Integer.parseInt(GetDecimalDigit(String.valueOf(currSymbol)));
            } else {
                digit = Integer.parseInt(String.valueOf(currSymbol));
            }
            sum += digit * magnitude;
            magnitude *= 16;
        }
        System.out.println(sum);
    }

    private static String GetDecimalDigit(String digit) throws Exception {
        if (digit.equals("A")) {
            digit = "10";
        } else if (digit.equals("B")) {
            digit = "11";
        } else if (digit.equals("C")) {
            digit = "12";
        } else if (digit.equals("D")) {
            digit = "13";
        } else if (digit.equals("E")) {
            digit = "14";
        } else if (digit.equals("F")) {
            digit = "15";
        } else if (15 < Integer.parseInt(digit)) {
            throw new Exception("Invalid digit");
        }
        return digit;
    }
}
