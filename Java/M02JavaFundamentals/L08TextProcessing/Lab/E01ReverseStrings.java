import java.util.Scanner;

public class E01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            stringBuilder.append(command);
            stringBuilder.reverse().toString();
            System.out.println(String.format("%s = %s", command, stringBuilder));
            stringBuilder.setLength(0);
            command = scanner.nextLine();
        }
    }
}