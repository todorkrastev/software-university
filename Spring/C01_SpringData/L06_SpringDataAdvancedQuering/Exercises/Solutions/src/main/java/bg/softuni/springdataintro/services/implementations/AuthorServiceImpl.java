package bg.softuni.springdataintro.services.implementations;

import bg.softuni.springdataintro.models.entites.Author;
import bg.softuni.springdataintro.repositories.AuthorRepository;
import bg.softuni.springdataintro.services.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(authorName -> {
                    String firstName = authorName.trim().split("\\s+")[0];
                    String lastName = authorName.trim().split("\\s+")[1];
                    Author author = new Author(firstName, lastName);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId =
                ThreadLocalRandom
                        .current().nextLong(1, authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElse(null);
    }
}
