import java.util.Scanner;

public class E07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getNewString(text, n));
    }

    public static StringBuilder getNewString(String text, int n) {
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sum.append(text);
        }
        return sum;
    }
}
