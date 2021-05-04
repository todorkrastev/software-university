import java.util.Scanner;

public class E06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input1 = scanner.nextLine().charAt(0);
        char input2 = scanner.nextLine().charAt(0);
        char input3 = scanner.nextLine().charAt(0);
        String char1 = String.valueOf(input1);
        String char2 = String.valueOf(input2);
        String char3 = String.valueOf(input3);

        String result = char1 + char2 + char3;
        System.out.println(result);
    }
}
