package E02Articles;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String initialAuthor, String initialContent, String initialTitle) {
        this.title = initialTitle;
        this.content = initialContent;
        this.author = initialAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }
}
