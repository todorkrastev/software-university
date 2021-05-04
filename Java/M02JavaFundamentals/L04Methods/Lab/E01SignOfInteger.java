import java.util.Scanner;

public class E01SignOfInteger {
    private static int input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        SignOfInteger(input);

    }

    public static void SignOfInteger(int input) {
        E01SignOfInteger.input = input;
        if (0 < input) {
            System.out.printf("The number %d is positive.", input);
        } else if (input < 0) {
            System.out.printf("The number %d is negative.", input);
        } else {
            System.out.printf("The number %d is zero.", input);
        }
    }
}
