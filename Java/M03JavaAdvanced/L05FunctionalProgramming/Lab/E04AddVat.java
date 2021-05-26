package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class E04AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        UnaryOperator<Double> calculateVat = value -> value * 1.20;

        String values = Arrays.stream(reader.readLine().trim().split(", "))
                .map(e -> String.format("%.2f", calculateVat.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.printf("Prices with VAT:%n%s", values);
    }
}
