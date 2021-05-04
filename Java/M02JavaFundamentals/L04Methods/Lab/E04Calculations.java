import java.util.Scanner;

public class E04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        int inputNum1 = Integer.parseInt(scanner.nextLine());
        int inputNum2 = Integer.parseInt(scanner.nextLine());

        switch (inputText) {
            case "add":
                add(inputNum1, inputNum2);
                break;
            case "multiply":
                multiply(inputNum1, inputNum2);
                break;
            case "subtract":
                subtract(inputNum1, inputNum2);
                break;
            case "divide":
                divide(inputNum1, inputNum2);
                break;
            default:
                break;
        }
    }

    public static void add(int inputNum1, int inputNum2) {
        System.out.println(inputNum1 + inputNum2);
    }

    public static void multiply(int inputNum1, int inputNum2) {
        System.out.println(inputNum1 * inputNum2);
    }

    public static void subtract(int inputNum1, int inputNum2) {
        System.out.println(inputNum1 - inputNum2);
    }

    public static void divide(int inputNum1, int inputNum2) {
        System.out.println(inputNum1 / inputNum2);
    }

}
