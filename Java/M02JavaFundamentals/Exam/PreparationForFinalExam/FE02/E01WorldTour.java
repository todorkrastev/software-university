package E02ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01WorldTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String stops = reader.readLine();

        String input;
        while (!"Travel".equals(input = reader.readLine())) {
            String[] split = input.trim().split(":");
            String command = split[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(split[1]);
                    String string = split[2];

                    if (0 <= index && index <= stops.length() - 1) {
                        stops = stops.substring(0, index) + string + stops.substring(index);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(split[1]);
                    int endIndex = Integer.parseInt(split[2]);

                    if (0 <= startIndex && startIndex <= stops.length() - 1 && 0 <= endIndex && endIndex <= stops.length() - 1) {
                        // inclusive!!!
                        stops = stops.substring(0, startIndex) + stops.substring(endIndex + 1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = split[1];
                    String newString = split[2];

                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }
                    System.out.println(stops);
                    break;
                default:
                    break;
            }
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }
}
