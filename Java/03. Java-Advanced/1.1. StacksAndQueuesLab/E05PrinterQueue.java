package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E05PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<String> queue = new ArrayDeque<>();

        String command;
        while (!"print".equals(command = reader.readLine())) {

            if (!"cancel".equals(command) && !command.isEmpty()) {
                queue.offer(command);
            } else if ("cancel".equals(command)) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.peek());
                    queue.poll();
                }
            }
        }
        queue
                .forEach(e -> System.out.println(queue.poll()));
    }
}