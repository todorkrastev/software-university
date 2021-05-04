package E02ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02DestinationMapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();
        String regEx = "([=]|[/])(?<destination>[A-Z][a-zA-Z]{2,})\\1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();

        int sumDigits = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");

            if (!list.contains(destination)) {
                list.add(destination);
                sumDigits += destination.length();
            }
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", list));
        System.out.printf("Travel Points: %d%n", sumDigits);
    }
}