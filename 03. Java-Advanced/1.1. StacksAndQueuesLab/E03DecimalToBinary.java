package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E03DecimalToBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int decimal = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal > 0) {

            while (decimal > 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        } else {
            System.out.println(0);
        }
    }
}