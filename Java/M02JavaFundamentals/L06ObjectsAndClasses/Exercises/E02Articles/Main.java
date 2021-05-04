package E02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(",\\s+");
        String initialTitle = articleData[0];
        String initialContent = articleData[1];
        String initialAuthor = articleData[2];

        Article article = new Article(initialAuthor, initialContent, initialTitle);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split(": ");
            String command = commandParts[0];
            String data = commandParts[1];
            switch (command) {
                case "Edit":
                    article.edit(data);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(data);
                    break;
                case "Rename":
                    article.rename(data);
                    break;
                default:
                    break;
            }
        }
        System.out.println(article);
    }
}
