package bg.softuni.springdataintro;

import bg.softuni.springdataintro.models.entites.Book;
import bg.softuni.springdataintro.services.AuthorService;
import bg.softuni.springdataintro.services.BookService;
import bg.softuni.springdataintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int input;
    private static final int startYear = 1987;
    private static final int endYear = 2015;
    private static String firstName;
    private static String lastName;


    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();


        printSeparatorLine();
        printWelcomeMessage();
        printSeparatorLine();

        String answer;
        do {
            do {
                validateInput("Please, select Query Number [1-4]");
            } while (input < 1 || input > 4);

            switch (input) {
                case 1 -> {
                    printSelectQueryMessage("1. Get all books after the year");
                    do {
                        validateInput("Please, select an year [1987 - 2015]. Example -> 2000");
                    } while (input < startYear || input > endYear);
                    p01_GetAllBooksAfterYear();
                }
                case 2 -> {
                    printSelectQueryMessage("2. Get all authors with at least one book with release date before selected year");
                    do {
                        validateInput("Please, select an year [1987 - 2015]. Example -> 1990");
                    } while (input < startYear || input > endYear);
                    p02_GetAllAuthorsWithAtLeastOneBookWithReleaseDateBefore();
                }
                case 3 -> {
                    printSelectQueryMessage("3. Get all authors ordered by the number of their books");
                    printSeparatorLine();
                    p03_GetAllAuthorsOrderedByNumberOfBooks();
                }
                case 4 -> {
                    printSelectQueryMessage("4. Get all books from selected author ordered by release date (descending)," +
                            "then by book title (ascending)");
                    do {
                        try {
                            System.out.println("Please, enter full name of an author. Example -> George Powell");
                            String[] fullName = reader.readLine().trim().split("\\s+");
                            firstName = fullName[0];
                            lastName = fullName[1];
                            printSeparatorLine();
                        } catch (Exception e) {
                            printSeparatorLine();
                            System.out.println("Invalid input");
                            printSeparatorLine();
                        }
                    } while (!((!firstName.isBlank() && !lastName.isBlank()) &&
                            (!firstName.matches("^\\d+(\\.\\d+)?") && !lastName.matches("^\\d+(\\.\\d+)?"))));

                    p04_GetAllBooksByAuthorNameOrderedByReleaseDataDescAndBookTitleAsc();
                }
            }
            printSeparatorLine();
            do {
                System.out.println("Would you like to continue exploring more queries?: [Y/N]");
                answer = reader.readLine().trim().toLowerCase();
            } while (!answer.equals("n") && !answer.equals("y"));
        } while (!answer.equals("n"));

        printSeparatorLine();
        printGoodbyeMessage();
        printSeparatorLine();
    }

    private void p04_GetAllBooksByAuthorNameOrderedByReleaseDataDescAndBookTitleAsc() {
        bookService
                .findAllBooksByAuthorsFirstAndLastNameOrderedByReleaseDataDescAndBootTitleAsc(firstName, lastName)
                .forEach(System.out::println);
    }

    private void p03_GetAllAuthorsOrderedByNumberOfBooks() {
        authorService
                .getAllAuthorsOrderedByCountOfBooks()
                .forEach(System.out::println);
    }

    private void p02_GetAllAuthorsWithAtLeastOneBookWithReleaseDateBefore() {
        bookService
                .findAllAuthorsWithBooksBeforeYear(input)
                .forEach(System.out::println);

    }

    private void p01_GetAllBooksAfterYear() {
        bookService
                .findAllBooksAfterYear(input)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void printGoodbyeMessage() {
        System.out.println("Thank you for spending your time exploring my code!");
    }

    private void validateInput(String message) {
        try {
            System.out.println(message);
            input = Integer.parseInt(reader.readLine());
            printSeparatorLine();
        } catch (Exception e) {
            printSeparatorLine();
            System.out.println("Invalid input!");
            printSeparatorLine();
        }
    }

    private void printSelectQueryMessage(String query) {
        System.out.printf("You selected Query: %s%n", query);
    }

    private void printSeparatorLine() {
        System.out.println("*".repeat(150));
    }

    private void printWelcomeMessage() {
        System.out.println("Hello There! Welcome to my code!");
    }
}
