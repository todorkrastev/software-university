import java.util.Scanner;

public class E02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder stringBuilder = new StringBuilder();

        String[] command = scanner.nextLine().trim().split("\\s+");

        for (int i = 0; i < command.length; i++) {
            String commandParts = command[i];
            for (int j = 0; j < commandParts.length(); j++) {
                stringBuilder.append(commandParts);
            }
        }
        System.out.println(stringBuilder);
    }
}