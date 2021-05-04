import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandParts = scanner.nextLine().trim().split(",\\s*?");

        String healthRegEx = "[^\\d+\\-*/.]";
        Pattern healthPattern = Pattern.compile(healthRegEx);

        String damageRegEx = "([-]?[\\d]+[.]?[\\d]*)";
        Pattern damagePattern = Pattern.compile(damageRegEx);

        Map<String, Map<Integer, Double>> map = new TreeMap<>();

        for (String commandPart : commandParts) {
            String command = commandPart.replace(" ", "");
            Matcher healthMatcher = healthPattern.matcher(command);

            StringBuilder sbHealth = new StringBuilder();

            while (healthMatcher.find()) {
                sbHealth.append(healthMatcher.group());
            }

            int sumHealth = 0;

            for (int j = 0; j < sbHealth.toString().length(); j++) {
                int currHealthNum = sbHealth.toString().charAt(j);
                sumHealth += currHealthNum;
            }

            Matcher damageMatcher = damagePattern.matcher(command);

            double sumDamage = 0;

            while (damageMatcher.find()) {
                sumDamage += Double.parseDouble(damageMatcher.group());
            }

            for (int k = 0; k < command.length(); k++) {
                char currSymbol = command.charAt(k);
                switch (currSymbol) {
                    case '*':
                        sumDamage *= 2;
                        break;
                    case '/':
                        sumDamage /= 2;
                        break;
                    default:
                        break;
                }
            }
            map.putIfAbsent(command, new TreeMap<>());
            map.get(command).put(sumHealth, sumDamage);

            sbHealth.setLength(0);
        }
        map
                .forEach((k, v) -> {
                    System.out.printf("%s - ", k);
                    v
                            .forEach((key, value) -> System.out.printf("%d health, %.2f damage%n", key, value));
                });
    }
}