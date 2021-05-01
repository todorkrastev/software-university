import java.util.Scanner;

public class E09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1 && count < input) {
                System.out.println(i);
                sum += i;
                count++;
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}
