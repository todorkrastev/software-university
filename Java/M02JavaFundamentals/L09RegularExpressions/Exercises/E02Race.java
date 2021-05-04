import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringRegex = "[A-Za-z]";
        String digitRegex = "\\d";

        Pattern stringPattern = Pattern.compile(stringRegex);
        Pattern digitPattern = Pattern.compile(digitRegex);

        List<String> list = Arrays.stream(scanner.nextLine().trim().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"end of race".equals(command)) {
            Matcher stringMatcher = stringPattern.matcher(command);
            StringBuilder stringBuilder = new StringBuilder();

            while (stringMatcher.find()) {
                stringBuilder.append(stringMatcher.group());
            }

            Matcher digitMatcher = digitPattern.matcher(command);
            int km = 0;
            while (digitMatcher.find()) {
                km += Integer.parseInt(digitMatcher.group());
            }
            if (list.contains(stringBuilder.toString())) {
                map.putIfAbsent(String.valueOf(stringBuilder), 0);
                map.put(String.valueOf(stringBuilder), map.get(stringBuilder.toString()) + km);
            }
            command = scanner.nextLine();
        }
        List<String> topThreeNames = new ArrayList<>();
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .forEach(e -> topThreeNames.add(e.getKey()));

        System.out.printf("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s\n", topThreeNames.get(0), topThreeNames.get(1), topThreeNames.get(2));
    }
}