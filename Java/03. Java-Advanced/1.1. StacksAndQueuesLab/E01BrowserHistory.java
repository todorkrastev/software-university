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


        ArrayDeque<String> stack = new ArrayDeque<>();

        String input;
        String currPage = "";
        while (!"Home".equals(input = reader.readLine())) {

            if ("back".equals(input)) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    currPage = stack.pop();
                }
            } else {
                if (!currPage.isEmpty()) {
                    stack.push(currPage);
                }
                currPage = input;
            }
            System.out.println(currPage);
        }
    }
}