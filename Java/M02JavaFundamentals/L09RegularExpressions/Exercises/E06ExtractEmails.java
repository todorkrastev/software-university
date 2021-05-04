import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String regEx = "([a-zA-Z0-9]+)([.,-]*)([a-zA-Z0-9]+)?(@)([a-zA-Z0-9]+)[\\-]?([a-zA-Z0-9]+)[.]([a-zA-Z0-9]+)(\\.[a-zA-Z0-9]+)?";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(command);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}