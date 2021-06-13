package bg.softuni.java_advanced.iterators_and_comparators.lab.P02_Library;

import java.util.Iterator;


public class Library implements Iterable<Book> {
    private final Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {

        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
    }
}
