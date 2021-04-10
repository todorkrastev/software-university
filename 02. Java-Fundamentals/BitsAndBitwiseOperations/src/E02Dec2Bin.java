import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E02Dec2Bin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (0 < number) {
            int binarySurplus = number % 2;
            number /= 2;
            stringBuilder.append(binarySurplus);
        }
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
    }
}