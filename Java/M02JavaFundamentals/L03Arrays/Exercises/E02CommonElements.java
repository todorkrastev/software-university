import java.util.Scanner;

public class E02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] input1 = scanner.nextLine().split(" ");


        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input1[i].equals(input[j])) {
                    System.out.print(input1[i] + " ");
                }
            }
        }
    }
}
