import java.util.Arrays;
import java.util.Scanner;

public class E05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < input.length; i++){
            if (input[i] % 2 == 0){
                sumEven += input[i];
            }
            else if (input[i] % 2 == 1){
                sumOdd += input[i];
            }
        }
        int difference = sumEven - sumOdd;
        System.out.println(difference);
    }
}
