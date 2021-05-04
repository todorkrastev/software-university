package E05ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01ActivationKeys {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String activationKey = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        String command;

        while (!"Generate".equals(command = reader.readLine())) {
            String[] commandParts = command.trim().split(">>>");
            String instruction = commandParts[0];

            switch (instruction) {
                case "Contains":
                    String substring = commandParts[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                        System.out.println(activationKey);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperLower = commandParts[1];
                    int startIndex = Integer.parseInt(commandParts[2]);
                    int endIndex = Integer.parseInt(commandParts[3]);

                    if (startIndex <= endIndex) {
                        switch (upperLower) {
                            case "Upper":
                                stringBuilder.append(activationKey.substring(startIndex, endIndex).toUpperCase());
                                break;
                            case "Lower":
                                stringBuilder.append(activationKey.substring(startIndex, endIndex).toLowerCase());
                                break;
                            default:
                                break;
                        }

                        activationKey = activationKey.substring(0, startIndex) + stringBuilder.toString() + activationKey.substring(endIndex);
                        System.out.println(activationKey);
                    }
                    break;
                case "Slice":
                    int startIndexSlice = Integer.parseInt(commandParts[1]);
                    int endIndexSlice = Integer.parseInt(commandParts[2]);

                    if (startIndexSlice <= endIndexSlice) {
                        stringBuilder.append(activationKey, startIndexSlice, endIndexSlice);
                        activationKey = activationKey.replace(stringBuilder.toString(), "");

                        System.out.println(activationKey);
                    }
                    break;
                default:
                    break;
            }
            stringBuilder.setLength(0);
        }
        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}