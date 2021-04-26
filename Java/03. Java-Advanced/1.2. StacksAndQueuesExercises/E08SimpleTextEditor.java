package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E08SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfOperations = Integer.parseInt(reader.readLine());
        ArrayDeque<String> textHistory = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numOfOperations; i++) {

            String[] split = reader.readLine().trim().split("\\s+");
            String command = split[0];

            switch (command) {
                case "1":
                    String append = split[1];
                    textHistory.push(stringBuilder.toString());
                    stringBuilder.append(append);
                    break;
                case "2":
                    int count = Integer.parseInt(split[1]);
                    textHistory.push(stringBuilder.toString());
                    stringBuilder.delete(stringBuilder.length() - count, stringBuilder.length());
                    break;
                case "3":
                    int index = Integer.parseInt(split[1]);
                    System.out.println(stringBuilder.charAt(index - 1));
                    break;
                case "4":
                    stringBuilder = new StringBuilder(textHistory.pop());
                    break;
                default:
                    break;
            }
        }
    }
}