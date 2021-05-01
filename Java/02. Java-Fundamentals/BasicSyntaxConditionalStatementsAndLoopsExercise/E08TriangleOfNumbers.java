import java.util.Scanner;

public class E08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++){
            for (int j = 1; j <= i; j++){
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
