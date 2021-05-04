import java.util.Random;
import java.util.Scanner;

public class E01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s+");

        Random random = new Random();

        for (int i = 0; i < array.length - 1; i++) {
            int randomIndex = random.nextInt(array.length);
            String temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        for (String s : array) {
            System.out.println(s);
        }
    }
}
