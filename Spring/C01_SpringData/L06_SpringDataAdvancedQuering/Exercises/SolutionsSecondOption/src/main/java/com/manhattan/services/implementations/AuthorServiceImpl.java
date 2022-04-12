package com.manhattan.services.implementations;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;
import com.manhattan.models.AuthorAndTotalBooksModel;
import com.manhattan.repositories.AuthorRepository;
import com.manhattan.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerAuthor(Author author) {
        if (!this.repository.existsByFirstNameAndLastName(author.getFirstName(), author.getLastName())) {
            this.repository.save(author);
        }
    }

    @Override
    public Author getRandomAuthor() {
        int size = (int) this.repository.count();
        Random random = new Random();
        int id = random.nextInt(size) + 1;
        return this.repository.findById(id).get();
    }

    @Override
    public Set<Author> getAllAuthors() {
        return new HashSet<>(this.repository.findAll());
    }

    @Override
    public Set<Book> getBooksByAuthor(String firstName, String lastName) {
        return this.repository
                .findByFirstNameAndLastName(firstName, lastName)
                .getBooks();
    }

    @Override
    public List<String> getAllAuthorsWithFirstNameEndsWith(String endName) {
        return this.repository.findAllByFirstNameEndingWith(endName)
                .stream()
                .map(x -> String.format("%s %s", x.getFirstName(), x.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTotalTotalNumberOfBookCopiesByAuthor() {
        return this.repository.allAllWithTotalBooksCount()
                .stream()
                .map(AuthorAndTotalBooksModel::toString)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public int getBooksCountByAuthorNames(String firstName, String lastName) {
        return this.repository.getBooksCountByAuthor(firstName, lastName);
    }
}
