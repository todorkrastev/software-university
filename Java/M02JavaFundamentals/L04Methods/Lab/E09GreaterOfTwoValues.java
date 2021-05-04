import java.util.Scanner;

public class E09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                int resultInt = getMax(firstNum,secondNum);
                System.out.println(resultInt);
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                char resultChar = getMax(firstChar, secondChar);
                System.out.println(resultChar);
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                String resultString = getMax(firstString, secondString);
                System.out.println(resultString);
                break;
            default:
                break;
        }
    }

    public static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
    }

    public static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        } else {
            return secondChar;
        }
    }

    public static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        } else {
            return secondString;
        }
    }
}
