import java.util.*;
import java.util.stream.Collectors;

public class E02SecondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandParts = command.trim().split("\\s+");
            String firstCommand = commandParts[0];

            switch (firstCommand) {
                case "reverse":
                    int startIndexReverse = Integer.parseInt(commandParts[2]);
                    int countReverse = Integer.parseInt(commandParts[4]);

                    List<String> listReverse = new ArrayList<>();

                    if (0 <= startIndexReverse && countReverse - 1 < list.size()) {
                        for (int i = startIndexReverse + countReverse - 1; i >= startIndexReverse; i--) {
                            listReverse.add(list.get(i));
                            list.remove(i);
                        }
                        Collections.reverse(listReverse);

                        for (int i = 0; i < listReverse.size(); i++) {
                            list.add(startIndexReverse, listReverse.get(i));
                        }
                    }
                    break;
                case "sort":
                    int startIndexSort = Integer.parseInt(commandParts[2]);
                    int countSort = Integer.parseInt(commandParts[4]);

                    List<String> listSort = new ArrayList<>();

                    if (0 <= startIndexSort && countSort - 1 < list.size()) {
                        for (int i = startIndexSort + countSort - 1; i >= startIndexSort; i--) {
                            listSort.add(list.get(i));
                            list.remove(i);
                        }
                        Collections.sort(listSort);

                        for (int i = listSort.size() - 1; i >= 0; i--) {
                            list.add(startIndexSort, listSort.get(i));
                        }
                    }
                    break;
                case "remove":
                    int removeIndex = Integer.parseInt(commandParts[1]);

                    if (0 <= removeIndex && removeIndex < list.size()) {
                        for (int i = removeIndex - 1; i >= 0; i--) {
                            list.remove(i);
                        }
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine().trim();
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}