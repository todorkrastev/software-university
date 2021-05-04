import java.util.Arrays;
import java.util.Scanner;

public class E01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 3;
        int[] arr = new int[size];

        for (int i = 0; i < 3; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            arr[i] = input;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Arrays.sort(arr);
            System.out.println(arr[i]);
        }
    }
}
