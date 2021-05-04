import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("[STARstar]");

        int destroyedCounter = 0;
        int attackedCounter = 0;

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            Matcher matcher = pattern.matcher(command);

            int count = 0;
            while (matcher.find()) {
                count++;
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < command.length(); j++) {
                stringBuilder.append((char) (command.charAt(j) - count));
            }
            String decryptedMessage = stringBuilder.toString();

            Pattern decryptedPattern = Pattern.compile("@(?<planet>[A-Za-z]+)([^@\\-!:>]*?):(?<population>\\d+\\.?\\d+)([^@\\-!:>]*?)!(?<attack>[A|D]+?)!([^@\\-!:>]*?)->(?<soldier>\\d+\\.?\\d+)");
            Matcher decryptedMatcher = decryptedPattern.matcher(decryptedMessage);

            while (decryptedMatcher.find()) {
                String planetName = decryptedMatcher.group("planet");
                String attackType = decryptedMatcher.group("attack");

                if (attackType.contains("D")) {
                    destroyedCounter++;
                    destroyedPlanets.add(planetName);
                } else if (attackType.contains("A")) {
                    attackedCounter++;
                    attackedPlanets.add(planetName);
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d%n", attackedCounter);
        if (!attackedPlanets.isEmpty()) {
            for (String planet : attackedPlanets) {
                System.out.printf("-> %s%n", planet);
            }
        }
        System.out.printf("Destroyed planets: %d%n", destroyedCounter);
        if (!destroyedPlanets.isEmpty()) {
            for (String planet : destroyedPlanets) {
                System.out.printf("-> %s%n", planet);
            }
        }
    }
}
