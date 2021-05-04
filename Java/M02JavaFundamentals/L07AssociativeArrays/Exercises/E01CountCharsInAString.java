import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().trim().split("\\s+");

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            for (int j = 0; j < word.length(); j++) {
                char letter = word.charAt(j);
                map.putIfAbsent(letter, 0);
                map.put(letter, map.get(letter) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c -> %d%n",
                    entry.getKey(),
                    entry.getValue());
        }
    }
}