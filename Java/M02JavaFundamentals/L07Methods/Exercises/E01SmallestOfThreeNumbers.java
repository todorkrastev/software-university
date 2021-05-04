import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(getSmallest(firstNum, secondNum, thirdNum));

    }

    public static int getSmallest(int firstNum, int secondNum, int thirdNum) {
        return Math.min(Math.min(firstNum, secondNum), thirdNum);
    }
}
