package E04ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01PasswordReset {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String password = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        String input;
        while (!"Done".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\s+");
            String command = split[0];

            switch (command) {
                case "TakeOdd":

                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 == 1) {
                            char currSymbol = password.charAt(i);
                            stringBuilder.append(currSymbol);
                        }
                    }
                    password = stringBuilder.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(split[1]);
                    int length = Integer.parseInt(split[2]);

                    password = password.substring(0, index) + password.substring(index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = split[1];
                    String substitute = split[2];

                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.printf("Your password is: %s%n", password);
    }
}
