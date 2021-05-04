package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E03ThirdProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, int[]> map = new TreeMap<>();


        int capacity = Integer.parseInt(reader.readLine());

        if (capacity < 1 || 10000 < capacity) {
            return;
        }

        String input;
        while (!"Statistics".equals(input = reader.readLine())) {
            // trim ???
            String[] split = input.trim().split("=");
            String command = split[0];

            switch (command) {
                case "Add":
                    String username = split[1];
                    int sent = Integer.parseInt(split[2]);
                    int received = Integer.parseInt(split[3]);

                    if (0 <= sent  && sent < capacity && 0 <= received && received < capacity) {
                        if (!map.containsKey(username)) {
                            map.putIfAbsent(username, new int[2]);
                            map.get(username)[0] = sent;
                            map.get(username)[1] = received;
                        }
                    }

                    // if it does not work properly, try without if else, only with putifAbsent!!!

                    break;
                case "Message":
                    String sender = split[1];
                    String receiver = split[2];

                    // if it does not work properly, make 2 separates if for map.containsKey!!!
                    if (map.containsKey(sender) && map.containsKey(receiver)) {
                        map.get(sender)[0] += 1;
                        map.get(receiver)[1] += 1;
                        // be really careful here!!! -> read one more required operation, if it does not work properly
                        if (capacity <= map.get(sender)[0] + map.get(sender)[1]) {
                            map.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                        if (capacity <= map.get(receiver)[0] + map.get(receiver)[1]) {
                            map.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    } else if (map.containsKey(sender) && !map.containsKey(receiver)) {
                        map.get(sender)[0] += 1;
                        if (capacity <= map.get(sender)[0] + map.get(sender)[1]) {
                            map.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                    } else if (!map.containsKey(sender) & map.containsKey(receiver)) {
                        map.get(receiver)[1] += 1;
                        if (capacity <= map.get(receiver)[0] + map.get(receiver)[1]) {
                            map.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    String emptyUN = split[1];

                    if (map.containsKey(emptyUN)) {
                        map.remove(emptyUN);
                    }
                    // be careful here - maybe only the records of sender/ receiver should be deleted, not the users!!!
                    if (emptyUN.equals("All")) {
                        map.clear();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.printf("Users count: %d%n", map.size());
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue()[1], a.getValue()[1]))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()[0] + e.getValue()[1]));
    }
}