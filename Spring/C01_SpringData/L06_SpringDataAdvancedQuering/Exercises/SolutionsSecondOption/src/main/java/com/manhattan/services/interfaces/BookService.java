package com.manhattan.services.interfaces;

import com.manhattan.entities.Book;
import com.manhattan.models.BookTitleAndPriceModel;
import com.manhattan.models.BookTitleEditionTypeAndPriceModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface BookService {

    void registerBook(Book book);

    List<String> getBookTitlesAccordingRestriction(String restriction);

    List<String> findGoldenEditionBooksWithCopiesLessThan(int limit);

    List<BookTitleAndPriceModel> findBooksWithPriceLowerThanAndHerThan(BigDecimal lower, BigDecimal higher);

    List<String> findBooksNotReleasedInYear(int year);

    List<BookTitleEditionTypeAndPriceModel> findBooksReleasedBefore(LocalDate date);

    List<String> getAllBooksWithTitlesContainsCaseInsensitive(String pattern);

    List<String> getAllBooksAuthorsLastNameStartsWith(String pattern);

    Long getCountOfBooksThatHasTitleLongerThan(int limit);

    List<String> getBookByTitle(String title);

    int increaseBooksReleasedAfter(LocalDate date, int copies);

    int deleteBooksWithCopiesLowerThan(int copies);

}
