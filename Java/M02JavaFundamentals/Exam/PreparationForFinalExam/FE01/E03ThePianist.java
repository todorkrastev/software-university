package E01ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E03ThePianist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, String[]> map = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().trim().split("\\|");
            String play = tokens[0];
            String playWriter = tokens[1];
            String clef = tokens[2];

            map.putIfAbsent(play, new String[2]);
            map.get(play)[0] = playWriter;
            map.get(play)[1] = clef;
        }
        String input;
        while (!"Stop".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\|");
            String command = split[0];

            switch (command) {
                case "Add":
                    String piece = split[1];
                    String composer = split[2];
                    String key = split[3];

                    if (map.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        map.put(piece, new String[2]);
                        map.get(piece)[0] = composer;
                        map.get(piece)[1] = key;

                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    String pieceRemove = split[1];

                    if (!map.containsKey(pieceRemove)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceRemove);
                    } else {
                        map.remove(pieceRemove);
                        System.out.printf("Successfully removed %s!%n", pieceRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceCK = split[1];
                    String newKey = split[2];

                    if (map.containsKey(pieceCK)) {
                        map.get(pieceCK)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", pieceCK, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceCK);
                    }
                    break;
                default:
                    break;
            }
        }
        map
                .forEach((k, v) -> System.out.printf("%s -> Composer: %s, Key: %s%n", k, v[0], v[1]));
    }
}