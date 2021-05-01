package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E07RecursiveFibonacci {
    public static long[] memoryForFib;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());
        memoryForFib = new long[num + 1];
        System.out.println(fib(num));
    }

    private static long fib(int num) {
        if (num < 2) {
            return 1;
        }

        if (memoryForFib[num] != 0) {
            return memoryForFib[num];
        }
        return memoryForFib[num] = fib(num - 1) + fib(num - 2);
    }
}