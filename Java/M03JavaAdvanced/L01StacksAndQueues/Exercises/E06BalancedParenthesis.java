package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E06BalancedParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            char currSymbol = input.charAt(i);

            if (currSymbol == '{' || currSymbol == '[' || currSymbol == '(') {
                stack.push(currSymbol);
            } else {
                if (!stack.isEmpty()) {
                    if (currSymbol == ')') {
                        if (stack.pop() != '(') {
                            isBalanced = false;
                        }
                    } else if (currSymbol == ']') {
                        if (stack.pop() != '[') {
                            isBalanced = false;
                        }
                    } else if (currSymbol == '}') {
                        if (stack.pop() != '{') {
                            isBalanced = false;
                        }
                    }
                } else {
                    isBalanced = false;
                }
                if (!isBalanced) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}