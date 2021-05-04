package E04ArticleTheSecond;

public class Article {
    private String title;
    private String content;
    private String author;

    @Override
    public String toString() {
        return String.format("%s - %s: %s%n", this.title, this.content, this.author);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
