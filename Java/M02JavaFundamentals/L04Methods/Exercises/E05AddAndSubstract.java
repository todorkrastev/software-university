import java.util.Scanner;

public class E05AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputFirst = Integer.parseInt(scanner.nextLine());
        int inputSecond = Integer.parseInt(scanner.nextLine());
        int inputThird = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(inputFirst, inputSecond, inputThird));
    }

    public static int subtract(int inputFirst, int inputSecond, int inputThird) {
        return sum(inputFirst, inputSecond, inputThird) - inputThird;
    }

    public static int sum(int inputFirst, int inputSecond, int inputThird) {
        return inputFirst + inputSecond;
    }
}
