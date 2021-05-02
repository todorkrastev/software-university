package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E09InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] mathExpression = reader.readLine().trim().split("\\s+");
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String currSymbol : mathExpression) {
            if (!"-+/*()".contains(currSymbol)) {
                outputQueue.offer(currSymbol);
            } else if (currSymbol.equals("(")) {
                operatorsStack.push(currSymbol);
            } else if (currSymbol.equals(")") && (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("("))) {
                outputQueue.offer(operatorsStack.pop());
                operatorsStack.pop();
            } else {
                if ("-+".contains(currSymbol)) {
                    while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                } else {
                    while (!operatorsStack.isEmpty() && !"+-(".contains(operatorsStack.peek())) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                }
                operatorsStack.push(currSymbol);
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));
    }
}