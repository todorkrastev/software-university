import java.util.Scanner;

public class E06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());
        String lengthNum = Integer.toString(inputNum);
        int sum = 0;
        int fact = 1;

        for (int digitsCount = 0; digitsCount < lengthNum.length(); digitsCount++) {
            int digit = lengthNum.charAt(digitsCount) - 48;
            for (int i = 1; i <= digit; i++) {
                fact *= i;
            }
            sum += fact;
            fact = 1;
        }

        if (sum == inputNum){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
