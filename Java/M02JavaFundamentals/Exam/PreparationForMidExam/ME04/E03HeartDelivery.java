import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        int currIndex = 0;
        int currValue;

        while (!"Love!".equals(command)) {
            String[] commandParts = command.trim().split("\\s+");
            int jumpLen = Integer.parseInt(commandParts[1]);


            currIndex += jumpLen;

            if (list.size() - 1 < currIndex) {
                currIndex = 0;
            }
            currValue = list.get(currIndex);
            if (0 < currValue) {
                list.set(currIndex, currValue - 2);
                if (list.get(currIndex).equals(0)) {
                    System.out.printf("Place %d has Valentine's day.%n", currIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currIndex);
            }
            command = scanner.nextLine();
        }
        int countPos = 0;
        int countNeg = 0;

        for (Integer integer : list) {
            if (integer <= 0) {
                countPos++;
            } else {
                countNeg++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", currIndex);
        if (countPos == list.size()) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", countNeg);
        }
    }
}