package bg.softuni.springdataintro.services;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> printAllTitlesBooksByGivenAgeRestriction(String ageRestriction);

    List<String> printAllTitlesWithGoldenEditionAndCopiesLessThan(String type, Integer copies);

    List<String> printAllTitlesWithPriceLowerThanOrHigherThan(String lowerLimit, String upperLimit);

    List<String> printAllTitlesThatAreNotPublishedInGivenYear(int year);

    List<String> printAllBooksReleasedBeforeGivenDate(int day, int month, int year);

    List<String> printAllAuthorsFullNameByGivenPattern(String pattern);

    List<String> printAllTitlesByGivenPattern(String pattern);

    List<String> printAllTitlesByFirstLettersOfAuthorsLastNameByGivenPattern(String pattern);

    int printCountOfBooksWhichTitleIsLongerThanGivenNumber(int number);

    List<String> printTotalNumberOfBookCopiesByAuthorOrderByTotalBookCopiesDesc();

    List<String> printTitleEditionTypeAgeRestrictionPriceByGivenTitle(String title);

    int printTotalAmountOfIncreasedCopies(String day, String month, String year, int copies);

    int removeBooksWithCopiesLowerThanGivenAmount(int copiesAmount);

    int returnsTotalAmountOfBooksByGivenAuthor(String firstName, String lastName);
}
