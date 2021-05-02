package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

public class E01BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<String> browserHistoryBack = new ArrayDeque<>();

        String input;
        String currentURL = "";
        while (!"Home".equals(input = reader.readLine())) {
            if ("back".equals(input)) {
                if (1 < browserHistoryBack.size()) {
                    browserHistoryBack.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                currentURL = input;
                browserHistoryBack.push(input);
            }
            if (browserHistoryBack.isEmpty()) {
                System.out.println(currentURL);
            } else {
                System.out.println(browserHistoryBack.peek());
            }
        }
    }
}