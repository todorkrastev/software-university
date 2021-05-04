import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(countVowels(input));

    }

    public static String countVowels(String input) {
        int countVowels = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.toLowerCase().charAt(i);
            if (letter == 97 || letter == 101 || letter == 105 || letter == 111 || letter == 117) {
                countVowels++;
            }
        }
        String result = String.valueOf(countVowels);
        return result;
    }
}
