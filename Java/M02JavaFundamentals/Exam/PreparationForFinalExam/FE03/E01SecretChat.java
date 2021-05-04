package E03ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01SecretChat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String message = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        String input;
        while (!"Reveal".equals(input = reader.readLine())) {
            String[] split = input.trim().split(":\\|:");
            String command = split[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(split[1]);

                    stringBuilder.append(message);
                    stringBuilder.insert(index, " ");

                    message = stringBuilder.toString();

                    stringBuilder.setLength(0);

                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = split[1];

                    if (message.contains(substring)) {
                        stringBuilder.append(substring).reverse();
                        message = message.substring(0, message.indexOf(substring)) + message.substring(message.indexOf(substring) + substring.length()) + stringBuilder.toString();
                        stringBuilder.setLength(0);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringCA = split[1];
                    String replacement = split[2];

                    message = message.replace(substringCA, replacement);
                    System.out.println(message);
                    break;
                default:
                    break;
            }
        }
        System.out.printf("You have a new text message: %s%n", message.toString());
    }
}
