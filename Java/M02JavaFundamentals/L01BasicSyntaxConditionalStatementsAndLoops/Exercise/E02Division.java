import java.util.Scanner;

public class E02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());
        int maxNum = Integer.MIN_VALUE;

        if (inputNum % 2 == 0){
            maxNum = 2;
        }
        if (inputNum % 3 == 0){
            maxNum = 3;
        }
        if (inputNum % 6 == 0){
            maxNum = 6;
        }
        if (inputNum % 7 == 0){
            maxNum = 7;
        }
        if (inputNum % 10 == 0){
            maxNum = 10;
        }
        if (inputNum % 2 != 0 && inputNum % 3 != 0 && inputNum % 6 != 0 && inputNum % 7 != 0 && inputNum % 10 != 0){
            System.out.println("Not divisible");
            return;
        }
        System.out.printf("The number is divisible by %d", maxNum);
    }
}
