package bg.softuni.java_advanced.iterators_and_comparators.lab.P02_Library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library(
                new Book("War and Peace", 1865, "Leo Tolstoy"),
                new Book("Ana Karenina", 1878, "Leo Tolstoy"));

        for (Book book : library) {
            System.out.println(book.toString());
        }
    }
}
