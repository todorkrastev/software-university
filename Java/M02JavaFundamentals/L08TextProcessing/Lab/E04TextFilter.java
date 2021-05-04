import java.util.Scanner;

public class E04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().trim().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : banList) {
            String asterisks = "*";
            asterisks = asterisks.repeat(bannedWord.length());
            while (text.contains(bannedWord)) {
                text = text.replaceAll(bannedWord, asterisks);
            }
        }
        System.out.println(text);
    }
}