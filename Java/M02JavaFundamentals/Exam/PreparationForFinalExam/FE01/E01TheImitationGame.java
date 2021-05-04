package E01ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01TheImitationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String encryptedMessage = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        String input;
        while (!"Decode".equals(input = reader.readLine())) {
            String[] split = input.split("\\|");
            String command = split[0];

            switch (command) {
                case "Move":
                    int numOfLetters = Integer.parseInt(split[1]);

                    stringBuilder.append(encryptedMessage, 0, numOfLetters);
                    encryptedMessage = encryptedMessage.replace(stringBuilder.toString(), "");
                    encryptedMessage = encryptedMessage.concat(stringBuilder.toString());
                    stringBuilder.setLength(0);

                    break;
                case "Insert":
                    int index = Integer.parseInt(split[1]);
                    String value = split[2];

                    stringBuilder.append(encryptedMessage);
                    stringBuilder.insert(index, value);
                    encryptedMessage = stringBuilder.toString();
                    stringBuilder.setLength(0);

                    break;
                case "ChangeAll":
                    String substring = split[1];
                    String replacement = split[2];

                    encryptedMessage = encryptedMessage.replace(substring, replacement);
                    break;
                default:
                    break;
            }
        }
        System.out.println(String.format("The decrypted message is: %s", encryptedMessage));
    }
}
