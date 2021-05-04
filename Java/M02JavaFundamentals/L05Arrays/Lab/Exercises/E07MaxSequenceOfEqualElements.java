import java.util.Scanner;

public class E07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int currNum = 0;
        int count = 1;
        int maxCount = 0;
        int numToPrint = 0;

        for (int i = 0; i < arr.length; i++) {
            currNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (currNum == arr[j]) {
                    count++;
                    if (maxCount < count) {
                        maxCount = count;
                        numToPrint = currNum;
                    }
                } else {
                    break;
                }
            }
            count = 1;
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(numToPrint + " ");
        }
    }
}
