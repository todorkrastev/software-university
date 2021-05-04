import java.util.Scanner;

public class E02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            input[i] = num;
        }
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.printf("%d ", input[i]);;
        }
    }
}
