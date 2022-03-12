package bg.softuni.springdataintro.services;

import bg.softuni.springdataintro.models.entites.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
