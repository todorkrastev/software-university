package com.manhattan.services.interfaces;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface AuthorService{
    void registerAuthor(Author author);

    Author getRandomAuthor();

    Set<Author> getAllAuthors();

    Set<Book> getBooksByAuthor(String firstName, String lastName);

    List<String> getAllAuthorsWithFirstNameEndsWith(String endName);

    List<String> getTotalTotalNumberOfBookCopiesByAuthor();

    int getBooksCountByAuthorNames(String firstName, String last_name);
}
