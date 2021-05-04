import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int currNum = arr[i];
            boolean isItBigger = true;
            for (int j = i + 1; j < arr.length; j++) {
                if(currNum <= arr[j]){
                    isItBigger = false;
                    break;
                }
            }
            if (isItBigger){
                System.out.print(currNum + " ");
            }
        }
        System.out.println(arr[arr.length - 1]);
    }
}
