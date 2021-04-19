import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E04Dec2Hex {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        long number = Long.parseLong(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (0 < number) {
            long digit = number % 16;
            String digit2String = String.valueOf(digit);
            stringBuilder.append(GetHexDigit(digit2String));
            number /= 16;
        }
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    private static String GetHexDigit(String digit) throws Exception {
        if (Integer.parseInt(digit) == 10) {
            digit = "A";
        } else if (Integer.parseInt(digit) == 11) {
            digit = "B";
        } else if (Integer.parseInt(digit) == 12) {
            digit = "C";
        } else if (Integer.parseInt(digit) == 13) {
            digit = "D";
        } else if (Integer.parseInt(digit) == 14) {
            digit = "E";
        } else if (Integer.parseInt(digit) == 15) {
            digit = "F";
        } else if (15 < Integer.parseInt(digit)) {
            throw new Exception("Invalid digit");
        }
        return digit;
    }
}