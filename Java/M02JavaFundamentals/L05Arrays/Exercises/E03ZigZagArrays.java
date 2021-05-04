import java.util.Arrays;
import java.util.Scanner;

public class E03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] arrFirst = new String[n];
        String[] arrSecond = new String[n];

        for (int i = 0; i < n; i++) {
           String[] input = scanner.nextLine().split(" ");
           String ElementFirst = input[0];
           String ElementSecond = input[1];

           if (i % 2 == 0){
               arrFirst[i] = ElementFirst;
               arrSecond[i] = ElementSecond;
           } else {
               arrFirst[i] = ElementSecond;
               arrSecond[i] = ElementFirst;
           }
        }
        System.out.println(String.join(" ", arrFirst));
        System.out.println(String.join(" ", arrSecond));
    }
}