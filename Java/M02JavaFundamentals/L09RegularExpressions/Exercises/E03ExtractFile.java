import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int indexFileName = input.lastIndexOf("\\");
        int indexFileExtension = input.lastIndexOf(".");

        String fileName = input.substring(indexFileName + 1, indexFileExtension);
        String fileExtension = input.substring(indexFileExtension + 1);

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", fileExtension);
    }
}
