package com.manhattan.services.implementations;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;
import com.manhattan.repositories.AuthorRepository;
import com.manhattan.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
}
