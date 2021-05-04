package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class E05Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] input = reader.readLine().trim().split(";");
        int[] startingTime = Arrays.stream(reader.readLine().trim().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<String> queue = new ArrayDeque<>();
        Map<String, Integer> robots = getLinkedHashMap(input);

        int[] processTime = new int[robots.size()];

        long totalTimeInSeconds = getTimeInSeconds(startingTime);

        String product;
        while (!"End".equals(product = reader.readLine())) {
            queue.offer(product);
        }

        while (!queue.isEmpty()) {
            totalTimeInSeconds++;
            String currProduct = queue.poll();
            boolean isAssigned = false;
            for (int i = 0; i < processTime.length; i++) {
                if (processTime[i] > 0) {
                    --processTime[i];
                }
            }

            for (int i = 0; i < processTime.length; i++) {
                if (processTime[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                        if (count == i) {
                            processTime[i] = entry.getValue();

                            long hours = totalTimeInSeconds / 3600;
                            hours %= 24;
                            long minutes = totalTimeInSeconds % 3600;
                            minutes /= 60;
                            long seconds = totalTimeInSeconds % 60;

                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", entry.getKey(), currProduct, hours, minutes, seconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                queue.offer(currProduct);
            }
        }
    }

    private static Map<String, Integer> getLinkedHashMap(String[] input) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        for (String s : input) {
            String[] split = s.trim().split("-");
            String robotName = split[0];
            Integer processTime = Integer.parseInt(split[1]);

            robots.putIfAbsent(robotName, processTime);
        }
        return robots;
    }

    private static int getTimeInSeconds(int[] startingTime) {
        int hours = startingTime[0];
        int minutes = startingTime[1];
        int seconds = startingTime[2];

        int hoursToSeconds = hours * 3600;
        int minutesToSeconds = minutes * 60;

        return hoursToSeconds + minutesToSeconds + seconds;
    }
}