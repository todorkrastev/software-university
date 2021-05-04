import java.util.Scanner;

public class E02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().trim().split("\\s+");
        String firstString = array[0];
        String secondString = array[1];

        int max = Math.max(firstString.length(), secondString.length());
        int min = Math.min(firstString.length(), secondString.length());

        int sum = 0;

        for (int i = 0; i < min; i++) {
            char firstChar = firstString.charAt(i);
            char secondChar = secondString.charAt(i);

            int result = firstChar * secondChar;

            sum += result;
        }

        for (int i = min; i < max; i++) {
            if (firstString.length() == max) {
                sum += firstString.charAt(i);
            } else {
                sum += secondString.charAt(i);
            }
        }
        System.out.println(sum);
    }
}