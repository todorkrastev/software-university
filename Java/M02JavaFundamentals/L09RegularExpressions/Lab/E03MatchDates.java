import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})([\\/\\-.])(?<month>\\w{3})\\2(?<year>\\d{4})\\b");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    matcher.group("day"),
                    matcher.group("month"),
                    matcher.group("year"));
        }
    }
}