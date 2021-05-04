import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputFirst = Integer.parseInt(scanner.nextLine());
        int inputSecond = Integer.parseInt(scanner.nextLine());

        getFActorial(inputFirst, inputSecond);

    }

    public static double getFActorial(int inputFirst, int inputSecond) {
        double resultFirst = 1;
        double resultSecond = 1;
        for (int i = 2; i <= inputFirst ; i++) {
            resultFirst *= i;
        }
        for (int i = 2; i <= inputSecond; i++) {
            resultSecond *= i;
        }
        double result = resultFirst / resultSecond;
        System.out.printf("%.2f", result);
        return result;
    }

}
