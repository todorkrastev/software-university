import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class E10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> mapName = new HashMap<>();
        HashMap<String, List<Integer>> mapLanguage = new HashMap<>();



        String command = scanner.nextLine();

        while (!"exam finished".equals(command)) {
            String[] commandParts = command.trim().split("-");
            String name = commandParts[0];
            String submission = commandParts[1];

            switch (submission) {
                case "banned":

                    mapName.remove(name);
                    break;
                default:
                    int points = Integer.parseInt(commandParts[2]);

                    mapName.put(name, points);

                    mapLanguage.putIfAbsent(submission, new ArrayList<>());
                    mapLanguage.get(submission).add(points);

                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Results: ");

        mapName
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Integer.compare(b.getValue(), a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach((userName) -> {
                    System.out.printf("%s | %d%n", userName.getKey(), userName.getValue());
                });

        System.out.println("Submissions: ");

        mapLanguage
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach((language) -> {
                    System.out.printf("%s - %d%n", language.getKey(), language.getValue().size());
                });
    }
}