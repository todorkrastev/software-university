package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13SerbianUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Map<String, Integer>> venuesInfo = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([\\w]+? ?[\\w]+? ?[\\w]+) @([\\w]+? ?[\\w]+? ?[\\w]+) (\\d+) (\\d+)$");

        String input;
        while (!"End".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group(1);
                String venues = matcher.group(2);
                int ticketsPrice = Integer.parseInt(matcher.group(3));
                int ticketsCount = Integer.parseInt(matcher.group(4));

                venuesInfo.putIfAbsent(venues, new LinkedHashMap<>());
                venuesInfo.get(venues).put(singer, !venuesInfo.get(venues).containsKey(singer)
                        ? ticketsCount * ticketsPrice : venuesInfo.get(venues).get(singer) + ticketsCount * ticketsPrice);
            }
        }
        venuesInfo.forEach((key, value) -> {
            System.out.println(key);
            value
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(v -> System.out.printf("#  %s -> %d%n", v.getKey(), v.getValue()));
        });
    }
}
