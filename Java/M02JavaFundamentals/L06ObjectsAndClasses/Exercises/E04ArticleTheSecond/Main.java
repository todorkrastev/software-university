package E04ArticleTheSecond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(",\\s+");
            String title = input[0];
            String content = input[1];
            String author = input[2];

            Article article = new Article(title, content, author);

            articles.add(article);
        }
        String command = scanner.nextLine();
        switch (command) {
            case "title":
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getTitle))
                        .forEach(a -> System.out.println(a.getTitle() + " - " + a.getContent() + ": " + a.getAuthor()));
                break;
            case "content":
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getContent))
                        .forEach(a -> System.out.println(a.getTitle() + " - " + a.getContent() + ": " + a.getAuthor()));
                break;
            case "author":
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(a -> System.out.println(a.getTitle() + " - " + a.getContent() + ": " + a.getAuthor()));
                break;
            default:
                break;
        }
    }
}
