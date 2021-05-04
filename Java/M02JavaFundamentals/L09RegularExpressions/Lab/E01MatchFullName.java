import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}