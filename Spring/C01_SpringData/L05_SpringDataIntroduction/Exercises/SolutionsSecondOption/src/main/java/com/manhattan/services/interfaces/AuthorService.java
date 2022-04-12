package com.manhattan.services.interfaces;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;

import java.util.Set;

public interface AuthorService{
    void registerAuthor(Author author);

    Author getRandomAuthor();

    Set<Author> getAllAuthors();

    Set<Book> getBooksByAuthor(String firstName, String lastName);
}
