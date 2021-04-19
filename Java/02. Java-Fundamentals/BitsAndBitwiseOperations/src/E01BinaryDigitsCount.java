import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01BinaryDigitsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());
        byte binaryDigit = Byte.parseByte(reader.readLine());
        int count = 0;


        while (0 < number) {
            int binarySurplus = number % 2;

            if (binarySurplus == binaryDigit) {
                count++;
            }

            number /= 2;
        }
        System.out.println(count);
    }
}