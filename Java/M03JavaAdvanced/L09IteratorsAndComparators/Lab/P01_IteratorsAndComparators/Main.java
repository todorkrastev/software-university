package bg.softuni.java_advanced.iterators_and_comparators.lab.P01_IteratorsAndComparators;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("War and Peace", 1865, "Leo Tolstoy");

        System.out.printf("%s %d %s", book.getTitle(), book.getYear(), book.getAuthors().get(0));
    }
}
