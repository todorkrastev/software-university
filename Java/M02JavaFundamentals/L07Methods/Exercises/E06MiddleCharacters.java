import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        getMiddleChar(input);

    }

    public static void getMiddleChar(String input) {
        int length = input.length();
        int middle = length / 2;
        if (input.length() % 2 == 1) {
            System.out.println(input.charAt(middle));
        } else {
            System.out.print(input.charAt(middle - 1));
            System.out.print(input.charAt(middle));
        }
    }
}
