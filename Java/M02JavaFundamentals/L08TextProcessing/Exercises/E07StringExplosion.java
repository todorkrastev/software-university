import java.util.Scanner;

public class E07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        int sumExplosion = 0;
        int currExplosion = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '>') {
                currExplosion = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }
            if (0 != sumExplosion && symbol == '>') {
                stringBuilder.append(symbol);
            } else if (0 == sumExplosion) {
                stringBuilder.append(symbol);
            } else {
                sumExplosion--;
            }
            sumExplosion += currExplosion;
            currExplosion = 0;
        }
        System.out.println(stringBuilder);
    }
}