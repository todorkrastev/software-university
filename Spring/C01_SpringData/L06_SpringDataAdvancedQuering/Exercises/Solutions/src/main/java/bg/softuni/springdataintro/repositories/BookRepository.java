package bg.softuni.springdataintro.repositories;

import bg.softuni.springdataintro.models.entites.Book;
import bg.softuni.springdataintro.models.enums.AgeRestriction;
import bg.softuni.springdataintro.models.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPriceLimit, BigDecimal upperPriceLimit);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate startDate, LocalDate endDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthor_FirstNameEndsWith(String pattern);

    List<Book> findAllByTitleContaining(String title);

    List<Book> findAllByAuthor_LastNameStartsWithOrderByTitleAsc(String pattern);

    @Query("SELECT count(b) FROM Book b WHERE LENGTH(b.title) > :number")
    int findAllByTitleLongerThanGivenNumber(int number);

    @Query("SELECT b, SUM(b.copies) AS total_copies " +
            "FROM Book b " +
            "GROUP BY b " +
            "ORDER BY total_copies DESC")
    List<Book> findTotalNumberOfBookCopiesByAuthorOrderByTotalBookCopiesDesc();

    @Query("SELECT b FROM Book b " +
            "WHERE b.title = :title")
    List<Book> findTitleEditionTypeAgeRestrictionPriceByGivenTitle(String title);

    @Modifying
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :copies " +
            "WHERE b.releaseDate > :date")
    int increaseBookCopies(LocalDate date, int copies);

    @Modifying
    @Query("DELETE FROM Book b " +
            "WHERE b.copies < :copiesAmount")
    int removeBooksWithCopiesLessThenCopiesAmount(int copiesAmount);

    @Query(value = "CALL total_amount_of_books_by_given_author(:firstName, :lastName);", nativeQuery = true)
    int totalAmountOfBooksByGivenAuthor(String firstName, String lastName);
}
