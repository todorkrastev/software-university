import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E08BitDestroyer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());
        int position = Integer.parseInt(reader.readLine());

        //after shift left with position we have mask with 1 value at current position and another are 0, but with ~(not) we have mask with 0 value at current position and another are 1
        int mask = ~(1 << position);
        // taken the whole number with set 0 only at current position and now we have another number
        int result = (number & mask);
        System.out.println(result);
    }
}
