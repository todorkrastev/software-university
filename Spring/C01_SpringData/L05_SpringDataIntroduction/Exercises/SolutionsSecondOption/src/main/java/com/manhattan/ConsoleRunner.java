package com.manhattan;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;
import com.manhattan.services.interfaces.AuthorService;
import com.manhattan.services.interfaces.BookService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printInfoMessage;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        printInfoMessage("Seeding...");
        this.seedService.seedAll();
        printInfoMessage("------------------- 01. Problem -------------------");
        this.getBooksAfter(2000);
        printInfoMessage("------------------- 02. Problem -------------------");
        this.authorsWithOneBookWithReleaseDateBefore(1990);
        printInfoMessage("------------------- 03. Problem -------------------");
        this.authorsOrderedByTheNumberOfTheirBooks();
        printInfoMessage("------------------- 04. Problem -------------------");
        this._04_GetAllBooksFromAuthorGeorgePowell();
    }

    /**
     * problem 1.	Get all books after the year 2000. Print only their titles.
     *
     * @param year
     */
    private void getBooksAfter(int year) {
        AtomicInteger count = new AtomicInteger();
        System.out.println(bookService.getBooksAfter(year)
                .stream()
                .map(b -> String.format("%3s. %s", count.incrementAndGet(), b.getTitle()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * problem 2.	Get all authors with at least one book with release date before 1990. Print their first name and
     * last name.
     *
     * @param year
     */
    private void authorsWithOneBookWithReleaseDateBefore(int year) {
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(bookService.getBooksBefore(year)
                .stream()
                .map(Book::getAuthor)
                .distinct()
                .map(a -> String.format("%3s. %s %s", count.incrementAndGet(), a.getFirstName(), a.getLastName()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * 3.	Get all authors, ordered by the number of their books (descending).
     * Print their first name, last name and book count.
     */
    private void authorsOrderedByTheNumberOfTheirBooks() {
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(authorService.getAllAuthors()
                .stream()
                .sorted(Comparator.comparing(a -> ((Author) a).getBooks().size()).reversed())
                .map(a -> String.format("%3s. %-20s\t|\t%d", count.incrementAndGet(), a.getFirstName() + " " + a.getLastName(),
                        a.getBooks().size()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * 4.	Get all books from author George Powell, ordered by their release date (descending),
     * then by book title (ascending). Print the book's title, release date and copies.
     */
    private void _04_GetAllBooksFromAuthorGeorgePowell() {
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(authorService.getBooksByAuthor("George", "Powell")
                .stream()
                .sorted((b1, b2) -> {
                    int result = b2.getReleaseDate().compareTo(b1.getReleaseDate());
                    if (result == 0) {
                        result = b1.getTitle().compareTo(b2.getTitle());
                    }
                    return result;
                })
                .map(book -> String.format("%3s. %-30s\t|\t%10s\t|\t%d", count.incrementAndGet(), book.getTitle(),
                        book.getReleaseDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        book.getCopies()))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
