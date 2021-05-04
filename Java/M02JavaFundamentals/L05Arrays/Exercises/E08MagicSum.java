import java.util.Scanner;

public class E08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        int inputNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int pairNum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){
                pairNum = arr[i] + arr[j];
                if (pairNum == inputNum) {
                    System.out.printf("%d %d%n", arr[i], arr[j]);
                }
            }
        }
    }
}
