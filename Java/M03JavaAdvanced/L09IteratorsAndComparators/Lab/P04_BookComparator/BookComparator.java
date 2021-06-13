package bg.softuni.java_advanced.iterators_and_comparators.lab.P04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {

        int result = first.getTitle().compareTo(second.getTitle());
        return result != 0 ? result : Integer.compare(first.getYear(), second.getYear());
    }
}
