package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class E14DragonArmy {
    public static void main(String[] args) throws IOException {
        final int DEFAULT_HEALTH = 250;
        final int DEFAULT_DAMAGE = 45;
        final int DEFAULT_ARMOR = 10;
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int dragonsToRead = Integer.parseInt(reader.readLine());
        while (dragonsToRead-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = "null".equals(tokens[2]) ? DEFAULT_DAMAGE : Integer.parseInt(tokens[2]);
            int health = "null".equals(tokens[3]) ? DEFAULT_HEALTH : Integer.parseInt(tokens[3]);
            int armor = "null".equals(tokens[4]) ? DEFAULT_ARMOR : Integer.parseInt(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }

            dragons.get(type).put(name, new int[]{damage, health, armor});
        }

        dragons.forEach((type, members) -> {
            final double[] avgStats = new double[3];
            members.values().forEach(x -> avgStats[0] += x[0]);
            members.values().forEach(x -> avgStats[1] += x[1]);
            members.values().forEach(x -> avgStats[2] += x[2]);
            for (int i = 0; i < avgStats.length; i++) {
                avgStats[i] /= members.size();
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgStats[0], avgStats[1], avgStats[2]);

            members.forEach((name, stats) ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            name, stats[0], stats[1], stats[2]));
        });
    }
}
