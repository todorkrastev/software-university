import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        short sum = 0;

        for (int i = 0; i < n; i++) {
            short input = Short.parseShort(scanner.nextLine());
            sum += input;
            if (255 < sum) {
                sum -= input;
                System.out.printf("Insufficient capacity!%n");
            }
        }
                System.out.printf("%d", sum);
    }
}

