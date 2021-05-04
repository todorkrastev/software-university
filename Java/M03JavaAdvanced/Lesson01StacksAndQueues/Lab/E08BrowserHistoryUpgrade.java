package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E08BrowserHistoryUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<String> browserHistoryBack = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForward = new ArrayDeque<>();

        String input;
        while (!"Home".equals(input = reader.readLine())) {

            if ("back".equals(input)) {
                if (1 < browserHistoryBack.size()) {
                    String currURL = browserHistoryBack.pop();
                    browserHistoryForward.push(currURL);
                    System.out.println(browserHistoryBack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(input)) {
                if (browserHistoryForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currForward = browserHistoryForward.pop();
                    System.out.println(currForward);
                    browserHistoryBack.push(currForward);
                }
            } else {
                browserHistoryBack.push(input);
                System.out.println(input);
                browserHistoryForward.clear();
            }
        }
    }
}