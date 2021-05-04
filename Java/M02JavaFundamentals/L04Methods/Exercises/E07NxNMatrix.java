import java.util.Scanner;

public class E07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer input = Integer.parseInt(scanner.nextLine());

        getMatrix(input);
    }
    public static void getMatrix(int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 1; j <= input; j++) {
                System.out.print(input + " ");
            }
            System.out.println();
        }
    }
}
