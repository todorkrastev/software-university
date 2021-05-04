import java.util.Scanner;

public class E03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();
        String codeWord = scanner.nextLine();


        int startIndex = codeWord.indexOf(keyWord);
        while (startIndex != -1) {
            codeWord = codeWord.replace(keyWord, "");
            startIndex = codeWord.indexOf(keyWord);
        }

        System.out.println(codeWord);
    }
}