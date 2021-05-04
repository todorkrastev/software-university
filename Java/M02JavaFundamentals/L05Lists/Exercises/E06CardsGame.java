import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!(firstHand.isEmpty() || secondHand.isEmpty())) {
            if (firstHand.get(0).equals(secondHand.get(0))) {
                firstHand.remove(0);
                secondHand.remove(0);
            } else if (firstHand.get(0) < secondHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
                firstHand.remove(0);
                secondHand.remove(0);
            } else {
                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));
                secondHand.remove(0);
                firstHand.remove(0);
            }
        }
        String player = "";
        int sum = 0;
        if (firstHand.isEmpty()) {
            player = "Second";
            for (Integer element : secondHand) {
                sum += element;
            }
        } else if (secondHand.isEmpty()) {
            player = "First";
            for (Integer element : firstHand) {
                sum += element;
            }
        }
        System.out.printf("%s player wins! Sum: %d%n", player, sum);
    }
}

