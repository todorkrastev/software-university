import java.util.Scanner;

public class E12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());

        while (inputNum % 2 != 0){
            System.out.println("Please write an even number.");
            inputNum = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The number is: %d", Math.abs(inputNum));
    }
}
