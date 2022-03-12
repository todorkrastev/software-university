package bg.softuni.springdataintro;

import bg.softuni.springdataintro.services.AuthorService;
import bg.softuni.springdataintro.services.BookService;
import bg.softuni.springdataintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;
    private static int input;


    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader reader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        printWelcomeMessage();

        do {
            do {
                validateInput("Please, select exercise number [1-14]");
            } while (input < 1 || input > 14);

            switch (input) {
                case 1 -> p01_BooksTitlesByAgeRestriction();
                case 2 -> p02_GoldenBooks();
                case 3 -> p03_BooksByPrice();
                case 4 -> p04_NotReleasedBooks();
                case 5 -> p05_BooksReleasedBeforeDate();
                case 6 -> p06_AuthorsSearch();
                case 7 -> p07_BooksSearch();
                case 8 -> p08_BookTitlesSearch();
                case 9 -> p09_CountBooks();
                case 10 -> p10_TotalBookCopies();
                case 11 -> p11_ReducedBook();
                case 12 -> p12_IncreaseBookCopies();
                case 13 -> p13_RemoveBooks();
                case 14 -> p14_StoredProcedure();
            }

            input = 0;

        } while (!isProgramRunning());

        printGoodbyeMessage();
    }

    private void p14_StoredProcedure() throws IOException {
        printSelectedExerciseMessage("14. Stored Procedure");

        System.out.println("Please, enter first and last name of desired author -> Amanda Rice");
        String[] split = reader.readLine().trim().split("\\s+");
        String firstName = split[0];
        String lastName = split[1];

        int totalBooks = this.bookService
                .returnsTotalAmountOfBooksByGivenAuthor(firstName, lastName);

        System.out.printf("%s %s has written %d books%n",
                firstName,
                lastName,
                totalBooks);
    }

    private void p13_RemoveBooks() throws IOException {
        printSelectedExerciseMessage("13. Remove Books");

        System.out.println("Please, select amount of copies -> 1000");
        int copiesAmount = Integer.parseInt(reader.readLine());

        int removedBooks = this.bookService
                .removeBooksWithCopiesLowerThanGivenAmount(copiesAmount);

        System.out.println("Total removed books: " + removedBooks);
    }

    private void p12_IncreaseBookCopies() throws IOException {
        printSelectedExerciseMessage("12. Increase Book Copies");

        System.out.println("Please, enter desired date -> 12 Oct 2005");
        String[] split = reader.readLine().trim().split("\\s+");
        String day = split[0];
        String month = split[1];
        String year = split[2];

        System.out.println("Please, enter desired book copies -> 100");
        int copies = Integer.parseInt(reader.readLine());

        int totalAffectedCopies = this.bookService
                .printTotalAmountOfIncreasedCopies(day, month, year, copies);

        System.out.println("Total amount of increased book copies: " + totalAffectedCopies);
    }

    private void p11_ReducedBook() throws IOException {
        printSelectedExerciseMessage("11. Reduced Book");

        System.out.println("Please, enter desired title -> Things Fall Apart");
        String title = reader.readLine().trim().toLowerCase();

        this.bookService
                .printTitleEditionTypeAgeRestrictionPriceByGivenTitle(title)
                .forEach(System.out::println);
    }

    private void p10_TotalBookCopies() {
        printSelectedExerciseMessage("10. Total Book Copies");

        this.bookService
                .printTotalNumberOfBookCopiesByAuthorOrderByTotalBookCopiesDesc()
                .forEach(System.out::println);
    }

    private void p09_CountBooks() throws IOException {
        printSelectedExerciseMessage("9. Count Books");

        System.out.println("Please, enter a number -> 12");
        int number = Integer.parseInt(reader.readLine());

        System.out.printf("There are %d books with longer title than %d symbols%n",
                this.bookService
                        .printCountOfBooksWhichTitleIsLongerThanGivenNumber(number),
                number);
    }

    private void p08_BookTitlesSearch() throws IOException {
        printSelectedExerciseMessage("8. Book Titles Search");

        System.out.println("Please, enter the first letter/s of the author's last name -> Ric");
        String pattern = reader.readLine().trim().toLowerCase();

        this.bookService
                .printAllTitlesByFirstLettersOfAuthorsLastNameByGivenPattern(pattern)
                .forEach(System.out::println);
    }

    private void p07_BooksSearch() throws IOException {
        printSelectedExerciseMessage("7. Books Search");

        System.out.println("Please, enter letter/s from desired book -> sK");
        String pattern = reader.readLine().trim().toLowerCase();

        this.bookService
                .printAllTitlesByGivenPattern(pattern)
                .forEach(System.out::println);
    }

    private void p06_AuthorsSearch() throws IOException {
        printSelectedExerciseMessage("6. Authors Search");

        System.out.println("Please, enter the last letter/s from the first name of an author -> e");
        String pattern = reader.readLine().trim().toLowerCase();

        this.bookService
                .printAllAuthorsFullNameByGivenPattern(pattern)
                .forEach(System.out::println);
    }

    private void p05_BooksReleasedBeforeDate() throws IOException {
        printSelectedExerciseMessage("5. Books Released Before Date");

        System.out.println("Please, enter date -> 12-04-1992");
        String[] split = reader.readLine().trim().split("\\s*-\\s*");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);

        this.bookService
                .printAllBooksReleasedBeforeGivenDate(day, month, year)
                .forEach(System.out::println);
    }

    private void p04_NotReleasedBooks() throws IOException {
        printSelectedExerciseMessage("4. Not Released Books");

        System.out.println("Please, select year -> 2000");
        int year = Integer.parseInt(reader.readLine());

        this.bookService
                .printAllTitlesThatAreNotPublishedInGivenYear(year)
                .forEach(System.out::println);

    }

    private void p03_BooksByPrice() throws IOException {
        printSelectedExerciseMessage("3. Books by Price");

        System.out.println("Please, select the lower price limit -> 5");
        String lowerLimit = reader.readLine();

        System.out.println("Please, select the upper price limit -> 40");
        String upperLimit = reader.readLine();

        this.bookService
                .printAllTitlesWithPriceLowerThanOrHigherThan(lowerLimit, upperLimit)
                .forEach(System.out::println);
    }

    private void p02_GoldenBooks() throws IOException {
        printSelectedExerciseMessage("2. Golden Books");

        System.out.println("Please, select edition type -> normal, promo or gold");
        String type = reader.readLine().trim().toUpperCase();

        System.out.println("Please, select number of copies -> 5000");
        int copies = Integer.parseInt(reader.readLine());

        this.bookService
                .printAllTitlesWithGoldenEditionAndCopiesLessThan(type, copies)
                .forEach(System.out::println);
    }

    private void p01_BooksTitlesByAgeRestriction() throws IOException {
        printSelectedExerciseMessage("1. Books Titles by Age Restriction");
        System.out.println("Please, select age restriction -> minor, teen or adult");

        String ageRestriction = this.reader.readLine().trim().toUpperCase();

        this.bookService
                .printAllTitlesBooksByGivenAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printGoodbyeMessage() {
        System.out.println("Thank you for spending your time exploring my code!");
        printSeparatorLine();
    }

    private boolean isProgramRunning() throws IOException {
        printSeparatorLine();

        String answer;
        do {
            System.out.println("Would you like to continue exploring more exercises?: [Y/N]");
            answer = this.reader.readLine().trim().toLowerCase();

            printSeparatorLine();
        } while (!answer.equals("n") && !answer.equals("y"));
        return !answer.equals("y");
    }

    private void validateInput(String message) {
        try {
            System.out.println(message);
            input = Integer.parseInt(this.reader.readLine());
            printSeparatorLine();
        } catch (Exception e) {
            printSeparatorLine();
            System.out.println("Invalid input!");
            printSeparatorLine();
        }
    }

    private void printSelectedExerciseMessage(String exercise) {
        System.out.printf("You selected exercise: %s%n", exercise);
    }

    private void printSeparatorLine() {
        System.out.println("*".repeat(150));
    }

    private void printWelcomeMessage() {
        printSeparatorLine();
        System.out.println("Hello There! Welcome to my code!");
        printSeparatorLine();
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
