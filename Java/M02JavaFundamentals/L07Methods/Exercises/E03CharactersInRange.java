import java.util.Scanner;

public class E03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char charFirst = scanner.nextLine().charAt(0);
        char charSecond = scanner.nextLine().charAt(0);

        getChar(charFirst, charSecond);
    }

    public static void getChar(char charFirst, char charSecond) {
        if (charFirst < charSecond) {
            charFirst += 1;
            for (int i = charFirst; i < charSecond; i++, charFirst++) {
                System.out.printf("%c ", charFirst);
            }
        } else {
            charSecond += 1;
            for (int i = charSecond; i < charFirst; i++, charSecond++) {
                System.out.printf("%c ", charSecond);
                ;
            }
        }
    }
}
