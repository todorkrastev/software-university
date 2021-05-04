import java.util.*;
import java.util.stream.Collectors;

public class E03ThirdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().trim().split(":"))
                .collect(Collectors.toList());

        List<String> newDeck = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"Ready".equals(command)) {
            String[] commandParts = command.trim().split("\\s+");
            String firstCommand = commandParts[0];

            switch (firstCommand) {
                case "Add":
                    String cardName = commandParts[1];

                    if (list.contains(cardName)) {
                        newDeck.add(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String cardNameInsert = commandParts[1];
                    int indexInsert = Integer.parseInt(commandParts[2]);

                    if (list.contains(cardNameInsert) && 0 <= indexInsert && indexInsert < newDeck.size()) {
                        newDeck.add(indexInsert, cardNameInsert);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardNameRemove = commandParts[1];
                    if (newDeck.contains(cardNameRemove)) {
                        newDeck.remove(cardNameRemove);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String firstCardName = commandParts[1];
                    String secondCardName = commandParts[2];
                    int firstIndex = newDeck.indexOf(firstCardName);
                    int secondIndex = newDeck.indexOf(secondCardName);

                    if (newDeck.contains(firstCardName) && newDeck.contains(secondCardName)) {
                        Collections.swap(newDeck, firstIndex, secondIndex);
                    }
                    break;
                case "Shuffle":
                    Collections.reverse(newDeck);
                    break;
                default:
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(newDeck.toString().replaceAll("[\\[\\],]", ""));
    }
}