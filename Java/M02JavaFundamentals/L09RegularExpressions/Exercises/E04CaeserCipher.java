import java.util.Scanner;

public class E04CaeserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currSymbol = (char) (text.charAt(i) + 3);
            stringBuilder.append(currSymbol);
        }
        System.out.println(stringBuilder);
    }
}
