package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E04MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currSymbol = input.charAt(i);
            if (currSymbol == '(') {
                stack.push(i);
            } else if (currSymbol == ')') {
                int startIndex = stack.pop();
                String content = input.substring(startIndex, i + 1);
                System.out.println(content);
            }
        }
    }
}
