import java.util.Arrays;
import java.util.Scanner;

public class E02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stringParts = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = "";
        int count = 0;

        while (!"End".equals(command = scanner.nextLine())) {

            int indexTarget = Integer.parseInt(command);

            if (indexTarget >= 0 && indexTarget < stringParts.length) {
                for (int i = 0; i < stringParts.length; i++) {
                    int temp = stringParts[indexTarget];

                    if (stringParts[i] != -1 && i != indexTarget) {
                        if (stringParts[i] > temp) {
                            stringParts[i] -= temp;
                        } else if (stringParts[i] <= temp) {
                            stringParts[i] += temp;
                        }
                    }
                }
                stringParts[indexTarget] = -1;
                count++;
            }
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (int stringPart : stringParts) {
            System.out.printf("%d ", stringPart);
        }
    }
}
