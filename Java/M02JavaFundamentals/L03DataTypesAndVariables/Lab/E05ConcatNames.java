import java.util.Scanner;

public class E05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = name1 + delimiter + name2;

        System.out.println(result);
    }
}
