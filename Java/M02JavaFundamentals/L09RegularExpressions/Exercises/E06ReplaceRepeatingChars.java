import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        char firstIndex = text.charAt(0);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstIndex);

        for (int i = 1; i < text.length(); i++) {
            char currSymbol = text.charAt(i);
            if (currSymbol != firstIndex) {
                firstIndex = text.charAt(i);
                stringBuilder.append(firstIndex);
            }
        }
        System.out.println(stringBuilder);
    }
}
