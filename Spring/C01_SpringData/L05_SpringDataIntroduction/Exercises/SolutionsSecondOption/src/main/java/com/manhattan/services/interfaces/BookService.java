package com.manhattan.services.interfaces;

import com.manhattan.entities.Book;
import com.manhattan.services.implementations.BookServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public interface BookService {

    void registerBook(Book book);

    Set<Book> getBooksAfter(int year);

    Set<Book> getBooksBefore(int year);
}
