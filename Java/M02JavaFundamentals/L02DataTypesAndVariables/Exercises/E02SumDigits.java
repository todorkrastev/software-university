import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String lengthInput = Integer.toString(input);
        int sum = 0;
        int digit = 0;

        while (input > 0) {
            sum += (input % 10);
            input /= 10;
        }

        System.out.println(sum);
    }
}
