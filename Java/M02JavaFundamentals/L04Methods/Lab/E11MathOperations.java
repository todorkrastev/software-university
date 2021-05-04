import java.util.Scanner;

public class E11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int input2 = Integer.parseInt(scanner.nextLine());

        switch (operator) {
            case "+":
                System.out.println(getAdd(input1, input2));
                break;
            case "-":
                System.out.println(getSubtract(input1, input2));
                break;
            case "*":
                System.out.println(getMultiply(input1, input2));
                break;
            case "/":
                System.out.println(getDivide(input1, input2));
                break;
            default:
                break;
        }

    }

    public static int getAdd(int input1, int input2) {
        return input1 + input2;
    }

    public static int getSubtract(int input1, int input2) {
        return input1 - input2;
    }

    public static int getMultiply(int input1, int input2) {
        return input1 * input2;
    }

    public static int getDivide(int inputFirst, int inputSecond) {
        return inputFirst / inputSecond;
    }
}
