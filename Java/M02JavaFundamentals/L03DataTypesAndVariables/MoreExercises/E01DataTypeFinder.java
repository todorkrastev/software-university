import java.util.Scanner;

public class E01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        while (!command.equals("END")) {
            Scanner input = new Scanner(command);
            if (input.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", command);
            } else if (input.hasNextInt()) {
                System.out.printf("%s is integer type%n", command);
            } else if (command.length() == 1) {
                System.out.printf("%s is character type%n", command);
            } else if (input.hasNextDouble()) {
                System.out.printf("%s is floating point type%n", command);
            } else if (input.hasNextLine()) {
                System.out.printf("%s is string type%n", command);
            }
            command = scanner.nextLine();
        }
    }
}

