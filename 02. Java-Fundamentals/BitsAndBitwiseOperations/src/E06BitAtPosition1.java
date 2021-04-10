import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E06BitAtPosition1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());

        //after shift left with 1 we have 1 value in mask at position 1 another are 0
        int mask = 1 << 1;

        //after shift right with 1 taken last value(0 or 1) because another are 0 using &
        int result = (number & mask) >> 1;
        System.out.println(result);
    }
}
