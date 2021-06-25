package bg.softuni.java_advanced.basic_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P02_RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());

        System.out.println(factorial(n));
    }

    private static long factorial(int n) {

        return n == 0 ? 1 : n * factorial(n - 1);
    }
}
