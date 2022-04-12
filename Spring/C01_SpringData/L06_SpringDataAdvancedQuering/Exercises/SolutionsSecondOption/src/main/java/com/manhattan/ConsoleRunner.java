package com.manhattan;

import com.manhattan.models.BookTitleAndPriceModel;
import com.manhattan.models.BookTitleEditionTypeAndPriceModel;
import com.manhattan.services.interfaces.AuthorService;
import com.manhattan.services.interfaces.BookService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.*;

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

        printMenu();
        int problemNumber = readIntFromConsole("Enter problem number: ");
        while (problemNumber != 0) {
            switch (problemNumber) {
                case 1 -> executeProblem1();
                case 2 -> executeProblem2();
                case 3 -> executeProblem3();
                case 4 -> executeProblem4();
                case 5 -> executeProblem5();
                case 6 -> executeProblem6();
                case 7 -> executeProblem7();
                case 8 -> executeProblem8();
                case 9 -> executeProblem9();
                case 10 -> executeProblem10();
                case 11 -> executeProblem11();
                case 12 -> executeProblem12();
                case 13 -> executeProblem13();
                case 14 -> executeProblem14();
                default -> printRedMessage("Unexpected value: " + problemNumber);
            }
            printMenu();
            problemNumber = readIntFromConsole("Enter problem number: ");
        }
    }

    /**
     * Problem 1.Books Titles by Age Restriction
     * Write a program that prints the titles of all books, for which the age restriction matches
     * the given input (minor, teen or adult). Ignore casing of the input.
     *
     * @throws IOException
     */
    private void executeProblem1() throws IOException {
        String restriction = readStringFromConsole("Enter restriction: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .getBookTitlesAccordingRestriction(restriction)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 2.Golden Books
     * Write a program that prints the titles of the golden edition books, which have less than 5000 copies.
     */
    private void executeProblem2() {
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findGoldenEditionBooksWithCopiesLessThan(5000)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 3. Books by Price
     * Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
     */
    private void executeProblem3() {
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findBooksWithPriceLowerThanAndHerThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(BookTitleAndPriceModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 4. Not Released Books
     * Write a program that prints the titles of all books that are NOT released in a given year.
     */
    private void executeProblem4() throws IOException {
        int year = readIntFromConsole("Enter release year: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findBooksNotReleasedInYear(year)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * problem 5. Books Released Before Date
     * * Write a program that prints the title, the edition type and the price of books,
     * * which are released before a given date. The date will be in the format dd-MM-yyyy.
     *
     * @throws IOException
     */
    private void executeProblem5() throws IOException {
        String strDate = readStringFromConsole("Enter release date in format /dd-MM-yyyy/: ");
        printInfoMessage("Result: ");
        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(this.bookService
                .findBooksReleasedBefore(date)
                .stream()
                .map(BookTitleEditionTypeAndPriceModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 6. Authors Search
     * Write a program that prints the names of those authors, whose first name ends with a given string.
     *
     * @throws IOException
     */
    private void executeProblem6() throws IOException {
        String endName = readStringFromConsole("Enter end of the first name: ");
        printInfoMessage("Result: ");
        System.out.println(this.authorService.getAllAuthorsWithFirstNameEndsWith(endName)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 7. Books Search
     * Write a program that prints the titles of books, which contain a given string (regardless of the casing).
     *
     * @throws IOException
     */
    private void executeProblem7() throws IOException {
        String pattern = readStringFromConsole("Enter pattern: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService.getAllBooksWithTitlesContainsCaseInsensitive(pattern)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 8. Book Titles Search
     * Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
     *
     * @throws IOException
     */
    private void executeProblem8() throws IOException {
        String pattern = readStringFromConsole("Enter the start of the Author's last name: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService.getAllBooksAuthorsLastNameStartsWith(pattern)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 9.	Count Books
     * Write a program that prints the number of books, whose title is longer than a given number.
     *
     * @throws IOException
     */
    private void executeProblem9() throws IOException {
        int limit = readIntFromConsole("Enter title limit: ");
        printInfoMessage("Result: ");
        System.out.printf("There are %d books with longer title than %d symbols",
                this.bookService.getCountOfBooksThatHasTitleLongerThan(limit), limit);
        System.out.println();
    }


    /**
     * Problem 10. Total Book Copies
     * Write a program that prints the total number of book copies by author. Order the results descending by total book copies.
     */
    private void executeProblem10() {
        printInfoMessage("Result: ");
        System.out.println(this.authorService.getTotalTotalNumberOfBookCopiesByAuthor()
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 11.	Reduced Book
     * Write a program that prints information (title, edition type, age restriction and price) for a book by given title.
     * When retrieving the book information select only those fields and do NOT include any other information in the returned result.
     *
     * @throws IOException
     */
    private void executeProblem11() throws IOException {
        String title = readStringFromConsole("Enter the book title: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService.getBookByTitle(title)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }


    /**
     * Problem 12.	* Increase Book Copies
     * Write a program that increases the copies of all books released after a given date with a given number.
     * Print the total amount of book copies that were added.
     *
     * @throws IOException
     */
    private void executeProblem12() throws IOException {
        String strDate = readStringFromConsole("Enter target date in the format /dd MMM yyyy/: ");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                // case-insensitive to parse JAN and FEB
                .parseCaseInsensitive()
                // add pattern
                .appendPattern("dd MMM yyyy")
                // create formatter (use English Locale to parse month names)
                .toFormatter(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(strDate, formatter);
        int copies = readIntFromConsole("Enter number to increment: ");
        printInfoMessage("Result: ");
        int modifiedBooks = this.bookService.increaseBooksReleasedAfter(date, copies);
        System.out.printf("%d books are released after %s, so total of %d book copies were added%n",
                modifiedBooks, formatter.format(date), modifiedBooks * copies);

    }

    /**
     * Problem 13. * Remove Books
     * Write a program that removes from the database those books, which copies are lower than a given number.
     * Print the number of books that were deleted from the database.
     *
     * @throws IOException
     */
    private void executeProblem13() throws IOException {
        int copies = readIntFromConsole("Enter copies: ");
        printInfoMessage("Result: ");
        System.out.printf("%d books was removed!%n", this.bookService.deleteBooksWithCopiesLowerThan(copies));

    }


    /**
     * Problem 14. * Stored Procedure
     * Using Workbench (or other similar tool) create a stored procedure, which receives an author's first and last name
     * and returns the total amount of books the author has written. Then write a program that receives an author's name
     * and prints the total number of books the author has written by using the stored procedure you've just created.
     * Please execute SQL before running problem
     * USE `bookshop_homework`;
     * DROP procedure IF EXISTS `udp_get_books_count_by_author`;
     *
     * DELIMITER $$
     * USE `bookshop_homework`$$
     * CREATE PROCEDURE `udp_get_books_count_by_author`(IN first_name varchar(255), IN last_name varchar(255), OUT count_out INT)
     * BEGIN
     *
     * SELECT COUNT(b.id)
     * FROM authors AS a
     * JOIN books AS b on b.author_id = a.id
     * WHERE a.first_name = first_name
     * AND a.last_name = last_name;
     *
     * END$$
     *
     * DELIMITER ;
     *
     * @throws IOException
     */
    private void executeProblem14() throws IOException {
        String[] names = readStringFromConsole("Enter author's names: ").split("\\s+");
        printInfoMessage("Result: ");
        int booksCountByAuthorNames = this.authorService.getBooksCountByAuthorNames(names[0], names[1]);
        System.out.printf("%s %s has written %d books%n", names[0],
                names[1], booksCountByAuthorNames);
    }


    private void printMenu() {
        printInfoMessage("--------------------------------------------------------------------------");
        StringBuilder sb = new StringBuilder()
                .append("Choose problem").append(System.lineSeparator())
                .append("--------------------------------").append(System.lineSeparator())
                .append("1. Books Titles by Age Restriction").append(System.lineSeparator())
                .append("2. Golden Books").append(System.lineSeparator())
                .append("3. Books by Price").append(System.lineSeparator())
                .append("4. Not Released Books").append(System.lineSeparator())
                .append("5. Books Released Before Date").append(System.lineSeparator())
                .append("6. Authors Search").append(System.lineSeparator())
                .append("7. Books Search").append(System.lineSeparator())
                .append("8. Book Titles Search").append(System.lineSeparator())
                .append("9. Count Books").append(System.lineSeparator())
                .append("10. Total Book Copies").append(System.lineSeparator())
                .append("11. Reduced Book").append(System.lineSeparator())
                .append("12. * Increase Book Copies").append(System.lineSeparator())
                .append("13. * Remove Books").append(System.lineSeparator())
                .append("14. * Stored Procedure").append(System.lineSeparator())
                .append("0. exit").append(System.lineSeparator());
        System.out.println(sb);
    }
}
