import java.util.Scanner;

public class E05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int charStart = Integer.parseInt(scanner.nextLine());
        int charEnd = Integer.parseInt(scanner.nextLine());

        for (int i = charStart; i <= charEnd; i++){
            char ch = (char) i;
            System.out.printf("%c ", ch);
        }
    }
}
