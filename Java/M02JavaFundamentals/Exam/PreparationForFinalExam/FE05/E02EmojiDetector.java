package E05ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02EmojiDetector {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();
        Map<String, long[]> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        long digitSum = 1;
        String emoji;
        String emojiToPrint = "";

        String emojiRegEx = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegEx);
        Matcher emojiMatcher = emojiPattern.matcher(input);

        while (emojiMatcher.find()) {
            emojiToPrint = emojiMatcher.group();
            emoji = emojiMatcher.group("emoji");
            int sumEmoji = 0;
            for (int i = 0; i < emoji.length(); i++) {
                char currSymbol = emoji.charAt(i);
                sumEmoji += currSymbol;
            }
            map.putIfAbsent(emojiToPrint, new long[2]);
            map.get(emojiToPrint)[0] += sumEmoji;
            if(!list.contains(emojiToPrint)) {
                list.add(emojiToPrint);
            }
        }

        String digitRegEx = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegEx);
        Matcher digitMatcher = digitPattern.matcher(input);

        while (digitMatcher.find()) {
            long digit = Integer.parseInt(digitMatcher.group());
            digitSum *= digit;
            map.get(emojiToPrint)[1] = digitSum;
        }

        System.out.printf("Cool threshold: %d%n", map.get(emojiToPrint)[1]);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", list.size());

        map
                .entrySet()
                .stream()
                .filter(e -> e.getValue()[0] >= e.getValue()[1])
                .forEach(e -> System.out.printf("%s%n", e.getKey()));

    }
}

// how to get the size of:
// map.get(emojiToPrint) [0] ??????
