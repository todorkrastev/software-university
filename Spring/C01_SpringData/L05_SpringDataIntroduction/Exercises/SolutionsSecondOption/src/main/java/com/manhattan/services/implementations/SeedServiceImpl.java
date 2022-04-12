package com.manhattan.services.implementations;

import com.manhattan.entities.*;
import com.manhattan.services.interfaces.AuthorService;
import com.manhattan.services.interfaces.BookService;
import com.manhattan.services.interfaces.CategoryService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private static final String RESOURCE_PATH = "src/main/resources/files/";
    private static final String BOOKS_FILE_NAME = "books.txt";
    private static final String AUTHORS_FILE_NAME = "authors.txt";
    private static final String CATEGORIES_FILE_NAME = "categories.txt";
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public SeedServiceImpl(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + AUTHORS_FILE_NAME))
                .stream()
                .filter(row -> !row.isBlank())
                .map(row -> row.split("\\s+"))
                .map(name -> new Author(name[0], name[1]))
                .forEach(this.authorService::registerAuthor);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + CATEGORIES_FILE_NAME))
                .stream()
                .filter(row -> !row.isBlank())
                .map(Category::new)
                .forEach(this.categoryService::registerCategory);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + BOOKS_FILE_NAME))
                .stream()
                .filter(row -> !row.isBlank())
                .map(this::getBookObject)
                .forEach(this.bookService::registerBook);
    }

    private Book getBookObject(String record) {
        String[] data = record.split("\\s+");
        Author author = authorService.getRandomAuthor();
        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

        String title = Arrays.stream(data)
                .skip(5)
                .collect(Collectors.joining(" "));

        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(title, "", editionType, price, copies, releaseDate, ageRestriction, categories, author);
    }
}
