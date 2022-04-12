package com.manhattan.repositories;

import com.manhattan.entities.AgeRestriction;
import com.manhattan.entities.Book;
import com.manhattan.entities.EditionType;
import com.manhattan.models.BookDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> findDistinctAllByReleaseDateAfter(LocalDate date);

    Set<Book> findDistinctAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction restriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int limit);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContains(String pattern);

    List<Book> findAllByAuthorLastNameStartsWith(String pattern);

    @Query("SELECT count(b) " +
            "FROM Book b " +
            "WHERE length(b.title) > :limit")
    long countAllByTitleLongerThan(@Param("limit") int limit);


    @Query("SELECT NEW com.manhattan.models.BookDetailsModel(b.title, b.editionType, b.ageRestriction, b.price) " +
            "FROM Book b " +
            "WHERE b.title = :title")
    List<BookDetailsModel>findBookByTitle(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :copies " +
            "WHERE b.releaseDate > :date ")
    int updateBooksCopiesReleasedAfter(LocalDate date, int copies);

    @Transactional
    @Modifying
    @Query("DELETE FROM Book b " +
            "WHERE b.copies < :copies")
    int deleteAllBooksByCopiesLessThan(int copies);

}
