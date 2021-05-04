import java.util.*;

public class E03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = Arrays.stream(scanner.nextLine()
                .trim()
                .split("\\s+"))
                .filter(a -> a.length() % 2 == 0)
                .toArray(String[]::new);

        for (String s : array) {
            System.out.println(s);
        }
    }
}
