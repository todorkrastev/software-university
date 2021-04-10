import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E07PthBit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());
        int position = Integer.parseInt(reader.readLine());

        //after shift left with position value we have 1 value in mask at current position but another are 0
        int mask = 1 << position;

        //after shift right with position value we have 0 or 1 at last position but another are 0 using &
        int result = (number & mask) >> position;

        System.out.println(result);
    }
}
