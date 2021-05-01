import java.util.Scanner;

public class E04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        String backwardsWord = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        backwardsWord = builder.toString();
        System.out.println(backwardsWord);
    }
}
