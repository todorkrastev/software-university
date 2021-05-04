package E01ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02AdAstra {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<String> list = new ArrayList<>();

        String input = reader.readLine();
        String regEx = "([|]|[#])(?<item>[a-zA-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<kcal>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        int totalKcal = 0;

        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            int kcal = Integer.parseInt(matcher.group("kcal"));

            String output = "Item: " + item + ", Best before: " + date + ", Nutrition: " + kcal;

            list.add(output);
            totalKcal += kcal;
        }
        int count = 0;
        while (2000 <= totalKcal) {
            count++;
            totalKcal -= 2000;
        }
        System.out.printf("You have food to last you for: %d days!%n", count);
        if (!list.isEmpty()) {
            list
                    .forEach(System.out::println);
        }
    }
}