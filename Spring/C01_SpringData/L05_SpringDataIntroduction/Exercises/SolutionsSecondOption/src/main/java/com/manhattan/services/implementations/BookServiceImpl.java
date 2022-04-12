package com.manhattan.services.implementations;

import com.manhattan.entities.Book;
import com.manhattan.repositories.BookRepository;
import com.manhattan.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerBook(Book book) {
        this.repository.save(book);
    }

    @Override
    public Set<Book> getBooksAfter(int year) {
        return this.repository.findDistinctAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public Set<Book> getBooksBefore(int year) {
        return this.repository.findDistinctAllByReleaseDateBefore(LocalDate.of(year,01,01));
    }
}
