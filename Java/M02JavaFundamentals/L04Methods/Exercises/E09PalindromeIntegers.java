import java.util.Scanner;

public class E09PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            getPalindrome(command);
            command = scanner.nextLine();
        }
    }

    private static String getPalindrome(String command) {


        StringBuilder reverse = new StringBuilder();
        String output = "";

        for (int i = command.length() - 1; i >= 0; i--) {
            reverse.append(command.charAt(i));
        }
        if (command.equals(reverse.toString())) {
            output = "true";
            System.out.println("true");
        } else {
            output = "false";
            System.out.println("false");
        }
        return output;
    }
}

