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
import org.springframework.transaction.annotation.Transactional;

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
    public List<String> printAllTitlesBooksByGivenAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction);

        return this.bookRepository
                .findAllByAgeRestriction(restriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllTitlesWithGoldenEditionAndCopiesLessThan(String type, Integer copies) {
        EditionType editionType = EditionType.valueOf(type);

        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllTitlesWithPriceLowerThanOrHigherThan(String lowerLimit, String upperLimit) {
        BigDecimal lowerPriceLimit = new BigDecimal(lowerLimit);
        BigDecimal upperPriceLimit = new BigDecimal(upperLimit);

        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(lowerPriceLimit, upperPriceLimit)
                .stream()
                .map(book -> String.format("%s - $%.2f",
                        book.getTitle(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllTitlesThatAreNotPublishedInGivenYear(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

        return this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(startDate, endDate)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllBooksReleasedBeforeGivenDate(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);

        return this.bookRepository
                .findAllByReleaseDateBefore(date)
                .stream()
                .map(book -> String.format("%s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllAuthorsFullNameByGivenPattern(String pattern) {
        return this.bookRepository
                .findAllByAuthor_FirstNameEndsWith(pattern)
                .stream()
                .map(book -> String.format("%s %s",
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllTitlesByGivenPattern(String pattern) {
        return this.bookRepository
                .findAllByTitleContaining(pattern)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllTitlesByFirstLettersOfAuthorsLastNameByGivenPattern(String pattern) {
        return this.bookRepository
                .findAllByAuthor_LastNameStartsWithOrderByTitleAsc(pattern)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int printCountOfBooksWhichTitleIsLongerThanGivenNumber(int number) {
        return this.bookRepository
                .findAllByTitleLongerThanGivenNumber(number);
    }

    @Override
    public List<String> printTotalNumberOfBookCopiesByAuthorOrderByTotalBookCopiesDesc() {
        return this.bookRepository
                .findTotalNumberOfBookCopiesByAuthorOrderByTotalBookCopiesDesc()
                .stream()
                .map(book -> String.format("%s %s - %d",
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printTitleEditionTypeAgeRestrictionPriceByGivenTitle(String title) {
        return this.bookRepository
                .findTitleEditionTypeAgeRestrictionPriceByGivenTitle(title)
                .stream()
                .map(book -> String.format("%s %s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getAgeRestriction().name(),
                        book.getPrice().doubleValue()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public int printTotalAmountOfIncreasedCopies(String day, String month, String year, int copies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String date = day
                .concat("-")
                .concat(month)
                .concat("-")
                .concat(year);

        LocalDate localDate = LocalDate.parse(date, formatter);

        int affectedRows = this.bookRepository
                .increaseBookCopies(localDate, copies);

        return affectedRows * copies;
    }

    @Override
    @Transactional
    public int removeBooksWithCopiesLowerThanGivenAmount(int copiesAmount) {
        return this.bookRepository
                .removeBooksWithCopiesLessThenCopiesAmount(copiesAmount);
    }

    @Override
    public int returnsTotalAmountOfBooksByGivenAuthor(String firstName, String lastName) {
        return this.bookRepository
                .totalAmountOfBooksByGivenAuthor(firstName, lastName);
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
