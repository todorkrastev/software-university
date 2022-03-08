package bg.softuni.springdataintro.services;

import bg.softuni.springdataintro.models.entites.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksBeforeYear(int year);

    List<String> findAllBooksByAuthorsFirstAndLastNameOrderedByReleaseDataDescAndBootTitleAsc(String firstName, String lastName);
}
