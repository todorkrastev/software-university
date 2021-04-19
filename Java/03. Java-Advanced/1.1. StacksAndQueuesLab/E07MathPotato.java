package bg.softuni.java_advanced.stacks_and_queues.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class E07MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<String> queue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(reader.readLine());

        int cycle = 1;

        while (queue.size() > 1) {

            //IntStream.range(1, n).forEach(i -> queue.offer(Objects.requireNonNull(queue.poll())));
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", queue.peek());
            } else {
                System.out.printf("Removed %s%n", queue.poll());
            }
            cycle++;
        }
        System.out.printf("Last is %s%n", queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1) {
            return false;
        }

        for (int i = 2; i <= cycle / 2; i++) {
            // condition for non-prime number
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}