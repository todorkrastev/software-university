import java.util.*;

public class E09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Lumpawaroo")) {
            String[] commandParts;
            String operand = "";

            if (command.contains("|")) {
                commandParts = command.split("\\s+\\|\\s+");
                operand = "|";
            } else {
                commandParts = command.split("\\s+->\\s+");
                operand = "->";
            }

            switch (operand) {
                case "|":
                    String side = commandParts[0];
                    String name = commandParts[1];

                    boolean check = false;

                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        if (entry.getValue().contains(name)) {
                            check = true;
                            break;
                        }
                    }

                    if (!check) {
                        if (!map.containsKey(side)) {
                            map.put(side, new ArrayList<>());
                            map.get(side).add(name);
                        } else if (map.containsKey(side) && !map.get(side).contains(name)) {
                            map.get(side).add(name);
                        }
                    }

                    break;

                case "->":
                    String user = commandParts[0];
                    String whichSide = commandParts[1];

                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        if (entry.getValue().contains(user)) {
                            map.get(entry.getKey()).remove(user);
                            break;
                        }
                    }

                    if (!map.containsKey(whichSide)) {
                        map.put(whichSide, new ArrayList<>());
                        map.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    } else if (map.containsKey(whichSide) && !map.get(whichSide).contains(user)) {
                        map.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    }

                    break;

                default:
                    break;
            }

            command = scanner.nextLine();
        }

        map
                .entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted((a, b) -> {
                    int result = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach((e) -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e
                            .getValue()
                            .stream()
                            .sorted((a, b) ->
                                    a.compareTo(b))
                            .forEach(u -> System.out.printf("! %s%n", u));

                });
    }
}