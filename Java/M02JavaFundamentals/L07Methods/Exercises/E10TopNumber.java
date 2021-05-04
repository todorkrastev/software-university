import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        getTopNumber(n);
    }

    private static void getTopNumber(int n) {
        for (int i = 10; i <= n ; i++) {
            int temp = i;
            int digit = 0;
            int count = 0;
            int sum = 0;
            while (temp > 0) {
                digit = temp % 10;
                if (digit % 2 == 1) {
                    count++;
                }
                sum += digit;
                temp /= 10;
            }
            if (0 < count && sum % 8 == 0) {
                System.out.println(i);;
            }
        }
    }
}
