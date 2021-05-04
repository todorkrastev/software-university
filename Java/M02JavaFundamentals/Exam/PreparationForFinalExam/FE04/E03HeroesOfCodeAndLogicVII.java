package E04ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());
        Map<String, int[]> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().trim().split("\\s+");
            String hn = split[0];
            int hp = Integer.parseInt(split[1]);
            int mp = Integer.parseInt(split[2]);

            //a hero can have a maximum of 100 HP and 200 MP!!!

            map.putIfAbsent(hn, new int[2]);
            map.get(hn)[0] = hp;
            map.get(hn)[1] = mp;
        }
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] commandParts = input.trim().split(" - ");
            String command = commandParts[0];
            String heroName = commandParts[1];

            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commandParts[2]);
                    String spellName = commandParts[3];

                    if (mpNeeded <= map.get(heroName)[1]) {
                        map.get(heroName)[1] -= mpNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, map.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandParts[2]);
                    String attacker = commandParts[3];

                    if (0 < map.get(heroName)[0] - damage) {
                        map.get(heroName)[0] -= damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, map.get(heroName)[0]);
                    } else {
                        map.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandParts[2]);

                    if (200 < map.get(heroName)[1] + amount) {
                        amount = 200 - map.get(heroName)[1];
                        map.get(heroName)[1] = 200;
                    } else {
                        map.get(heroName)[1] += amount;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(commandParts[2]);

                    if (100 < map.get(heroName)[0] + healAmount) {
                        healAmount = 100 - map.get(heroName)[0];
                        map.get(heroName)[0] = 100;
                    } else {
                        map.get(heroName)[0] += healAmount;
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, healAmount);
                    break;
                default:
                    break;
            }
        }
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
                .forEach(e -> System.out.printf("%s%n" +
                        "  HP: %d%n" +
                        "  MP: %d%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}