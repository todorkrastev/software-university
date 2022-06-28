import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an character: ");
        char c = scan.nextLine().charAt(0);

        System.out.print("Please enter the height: ");
        int height = Integer.parseInt(scan.nextLine());

        printPyramid(c, height);
    }

    public static void printPyramid(char c, int height) {
        StringBuilder pyramid = new StringBuilder();
        for (int i = 0; i < height; i++) {
            String spaces = new String(new char[height - i - 1]).replace('\0', ' ');
            String chars = new String(new char[2*i + 1]).replace('\0', c);
            pyramid.append(spaces).append(chars).append(System.lineSeparator());
        }
        System.out.println(pyramid);
    }
}
