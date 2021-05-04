import java.util.Arrays;
import java.util.Scanner;

public class E06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] input1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;

        for (int i = 0; i < input.length; i++){
            sum += input[i];

            if (input[i] != input1[i]){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
