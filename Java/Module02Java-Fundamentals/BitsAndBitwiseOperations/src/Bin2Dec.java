import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E03Bin2Dec {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        System.out.println("Please, enter a binary number.");
        String number = reader.readLine();
        int magnitude = 1;
        int sum = 0;

        for (int i = number.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += digit * magnitude;
            magnitude *= 2;
        }
        System.out.println(sum);
    }
}
