import java.util.Arrays;
import java.util.Scanner;

public class E04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(w -> w.length() % 2 == 0).toArray(String[]::new);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
