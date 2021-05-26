package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();
        Predicate<String> isUppercase = str -> str != null && !str.isEmpty() && Character.isUpperCase(str.charAt(0));

        List<String> getUppercaseWords = Arrays.stream(input.trim().split("\\s+"))
                .filter(isUppercase)
                .collect(Collectors.toList());

        System.out.println(getUppercaseWords.size());

        System.out.println(getUppercaseWords.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
