import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E09OddTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] array = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = array[0];

        for (int i = 1; i < array.length; i++)
        {
            result = result ^ array[i];
        }

        System.out.println(result);

        //example with first input:result=numbers[0]=1=001; result=010^001=011; result=011^011=000; 010^000=010; 011^010=001; 001^001=000; result=011^000=011=3;
    }
}
