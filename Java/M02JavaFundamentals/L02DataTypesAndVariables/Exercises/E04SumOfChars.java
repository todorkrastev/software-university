import java.util.Scanner;

public class E04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        int sum = 0;


        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            int ascii = input.charAt(0);
            sum += ascii;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
