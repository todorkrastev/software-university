import java.util.Scanner;

public class E12RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumOfDigits = 0;
        int digit = 0;

        for (int i = 1; i <= n; i++){
            digit = i;
            sumOfDigits = 0;

            while (digit > 0){
                sumOfDigits += digit % 10;
                digit /= 10;

            }
            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11){
                System.out.printf("%d -> True%n", i);
            }
            else{
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}

