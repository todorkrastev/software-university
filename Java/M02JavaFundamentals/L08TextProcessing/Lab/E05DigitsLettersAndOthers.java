import java.util.Scanner;

public class E05DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder characters = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (Character.isDigit(character)) {
                digits.append(character);
            } else if (Character.isLetter(character)) {
                letters.append(character);
            } else {
                characters.append(character);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(characters);
    }
}