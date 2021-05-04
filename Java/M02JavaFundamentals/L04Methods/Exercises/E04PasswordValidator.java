import java.util.Scanner;

public class E04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isPasswordValid = true;

        if (!ruleCharacters(input)) {
            isPasswordValid = false;
        }
        if (!ruleLettersDigits(input)) {
            isPasswordValid = false;
        }
        if (!ruleLessDigits(input)) {
            isPasswordValid = false;
        }
        if (isPasswordValid) {
            System.out.println("Password is valid");
        }

    }

    public static boolean ruleCharacters(String input) {
        if (6 <= input.length() && input.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    public static boolean ruleLettersDigits(String input) {
        boolean isLetterOrDigit = true;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.toLowerCase().charAt(i);
            if ('a' <= letter && letter <= 'z') {
                isLetterOrDigit = true;
            } else if ('0' <= letter && letter <= '9') {
                isLetterOrDigit = true;
            } else {
                isLetterOrDigit = false;
                break;
            }
        }
        if (!isLetterOrDigit) {
            System.out.println("Password must consist only of letters and digits");
            return false;
        } else {
            return true;
        }
    }

    public static boolean ruleLessDigits(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (48 <= letter && letter <= 57) {
                count++;
            }
        }
        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
}
