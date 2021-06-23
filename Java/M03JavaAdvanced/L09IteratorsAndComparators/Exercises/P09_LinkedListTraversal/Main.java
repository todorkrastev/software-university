package bg.softuni.java_advanced.iterators_and_comparators.exercises.P09_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());
        LinkedList list = new LinkedList();
        while (n-- > 0) {
            String[] input = reader.readLine().trim().split("\\s+");
            if ("Add".equals(input[0])) {
                list.add(Integer.parseInt(input[1]));
            } else {
                list.remove(Integer.parseInt(input[1]));
            }
        }
        System.out.println(list.getSize());
        list.forEach(e -> System.out.print(e + " "));
    }
}
