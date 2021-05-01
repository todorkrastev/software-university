import java.util.Arrays;
import java.util.Scanner;

public class E02EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String[] numNames = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };

        input %= 10;

        if (0 <= input && input < 11){
            System.out.println(numNames[input]);
        }
    }
}
