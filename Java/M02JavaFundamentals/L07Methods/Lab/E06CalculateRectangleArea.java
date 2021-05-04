import java.util.Scanner;

public class E06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(getRectangleArea(width, length));;

    }

    public static int getRectangleArea(int width, int length) {
        return width * length;
    }
}
