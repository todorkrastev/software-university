package com.manhattan.services.implementations;

import com.manhattan.entities.AgeRestriction;
import com.manhattan.entities.Book;
import com.manhattan.entities.EditionType;
import com.manhattan.models.BookDetailsModel;
import com.manhattan.models.BookTitleAndPriceModel;
import com.manhattan.models.BookTitleEditionTypeAndPriceModel;
import com.manhattan.repositories.BookRepository;
import com.manhattan.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerBook(Book book) {
        this.repository.save(book);
    }

    @Override
    public List<String> getBookTitlesAccordingRestriction(String restrictionName) {
        AgeRestriction restriction = AgeRestriction.valueOf(restrictionName.toUpperCase());
        return this.repository.findAllByAgeRestriction(restriction)
                .stream()
                .map(b -> b.getTitle())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findGoldenEditionBooksWithCopiesLessThan(int limit) {
        return this.repository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, limit)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookTitleAndPriceModel> findBooksWithPriceLowerThanAndHerThan(BigDecimal lower, BigDecimal higher) {
        return this.repository.findAllByPriceLessThanOrPriceGreaterThan(lower, higher)
                .stream()
                .map(b -> new BookTitleAndPriceModel(b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksNotReleasedInYear(int year) {
        LocalDate dateBefore = LocalDate.of(year, 1, 1);
        LocalDate dateAfter = LocalDate.of(year, 12, 31);
        return this.repository.findAllByReleaseDateBeforeOrReleaseDateAfter(dateBefore, dateAfter)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookTitleEditionTypeAndPriceModel> findBooksReleasedBefore(LocalDate date) {
        return this.repository.findAllByReleaseDateBefore(date)
                .stream()
                .map(b -> new BookTitleEditionTypeAndPriceModel(b.getTitle(), b.getEditionType(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksWithTitlesContainsCaseInsensitive(String pattern) {
        return this.repository.findAllByTitleContains(pattern)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksAuthorsLastNameStartsWith(String pattern) {
        return this.repository.findAllByAuthorLastNameStartsWith(pattern)
                .stream()
                .map(b -> String.format("%s (%s %s)", b.getTitle(), b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public Long getCountOfBooksThatHasTitleLongerThan(int limit) {
        return this.repository.countAllByTitleLongerThan(limit);
    }

    @Override
    public List<String> getBookByTitle(String title) {
        return this.repository.findBookByTitle(title)
                .stream()
                .map(BookDetailsModel::toString)
                .collect(Collectors.toList());
    }

    @Override
    public int increaseBooksReleasedAfter(LocalDate date, int copies) {
        return this.repository.updateBooksCopiesReleasedAfter(date, copies);
    }

    @Override
    public int deleteBooksWithCopiesLowerThan(int copies) {
        return this.repository.deleteAllBooksByCopiesLessThan(copies);
    }
}
