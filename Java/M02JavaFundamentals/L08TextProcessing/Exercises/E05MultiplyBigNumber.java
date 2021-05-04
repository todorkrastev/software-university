import java.util.Scanner;

public class E05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int digit = Integer.parseInt(scanner.nextLine());

        StringBuilder stringBuilder = new StringBuilder();
        int surplus = 0;


        if (digit == 0) {
            System.out.println(0);
            return;
        }

        while (num.charAt(0) == '0') {
            num = num.substring(1);
            if (num.isEmpty()) {
                System.out.println(0);
                return;
            }
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int currDigit = Integer.parseInt(String.valueOf(num.charAt(i)));
            int result = currDigit * digit + surplus;
            surplus = 0;

            if (9 < result) {
                surplus = result / 10;
                result %= 10;
            }

            stringBuilder.append(result);
        }
        if (surplus != 0) {
            stringBuilder.append(surplus);
        }
        stringBuilder.reverse();
        System.out.println(stringBuilder);
     }
}