package bg.softuni.springdataintro.services.implementations;

import bg.softuni.springdataintro.models.entites.Author;
import bg.softuni.springdataintro.models.entites.Book;
import bg.softuni.springdataintro.models.entites.Category;
import bg.softuni.springdataintro.models.enums.AgeRestriction;
import bg.softuni.springdataintro.models.enums.EditionType;
import bg.softuni.springdataintro.repositories.BookRepository;
import bg.softuni.springdataintro.services.AuthorService;
import bg.softuni.springdataintro.services.BookService;
import bg.softuni.springdataintro.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    public static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(bookInfo -> {

                    Book book = createBook(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksBeforeYear(int year) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s",
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorsFirstAndLastNameOrderedByReleaseDataDescAndBootTitleAsc(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .distinct()
                .collect(Collectors.toList());
    }


    private Book createBook(String bookInfo) {
        int editionTypeInput = Integer.parseInt(bookInfo.trim().split("\\s+")[0]);
        EditionType editionType = EditionType.values()[editionTypeInput];

        String dateInput = bookInfo.trim().split("\\s+")[1];
        LocalDate releaseData = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("d/M/yyyy"));

        String copiesInput = bookInfo.trim().split("\\s+")[2];
        Integer copies = Integer.valueOf(copiesInput);

        String priceInput = bookInfo.trim().split("\\s+")[3];
        BigDecimal price = new BigDecimal(priceInput);

        int ageRestrictionInput = Integer.parseInt(bookInfo.trim().split("\\s+")[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionInput];

        String[] split = bookInfo.trim().split("\\s+");

        String title =
                Arrays
                        .stream(split)
                        .skip(5)
                        .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories =
                categoryService
                        .getRandomCategories();


        return new Book(editionType, releaseData, copies, price, ageRestriction, title, author, categories);
    }
}
