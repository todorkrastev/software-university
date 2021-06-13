package bg.softuni.java_advanced.iterators_and_comparators.exercises.P01_ListyOperator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<String> stringList = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyOperator listyOperator = new ListyOperator(stringList);

        String command;
        while (!"END".equals(command = reader.readLine())) {
            switch (command) {
                case "Move":
                    System.out.println(listyOperator.move());
                    break;
                case "Print":
                    listyOperator.print();
                    break;
                case "HasNext":
                    System.out.println(listyOperator.hasNext());
                    break;
                default:
                    break;
            }
        }
    }
}
