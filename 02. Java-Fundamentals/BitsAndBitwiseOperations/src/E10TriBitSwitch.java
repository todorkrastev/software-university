import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E10TriBitSwitch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());
        int position = Integer.parseInt(reader.readLine());

        // we need 111 at current position and int 7 = 111
        int mask = 7 << position;

        //1 ^ 1 = 0, 0 ^ 1 = 1
        int result = number ^ mask;

        System.out.println(result);
    }
}
