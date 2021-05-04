import java.util.Scanner;

public class E06EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int sumRight = 0;
        for (int number: numbers) {
            sumRight += number;
        }

        int sumLeft = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumRight -= numbers[i];
            if (sumLeft == sumRight) {
                System.out.println(i);
                return;
            }
            sumLeft += numbers[i];
        }
        System.out.println("no");
    }
}

