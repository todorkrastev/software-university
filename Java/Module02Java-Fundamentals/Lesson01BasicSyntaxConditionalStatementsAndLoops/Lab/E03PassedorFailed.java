import java.util.Scanner;

public class E03PassedorFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        if (3 <= input) {
            System.out.println("Passed!");
        } else if (input < 3){
            System.out.println("Failed!");
        }
    }
}
