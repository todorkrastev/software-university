package com.manhattan.repositories;

import com.manhattan.entities.Author;
import com.manhattan.models.AuthorAndTotalBooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Author findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByFirstNameEndingWith(String endName);

    @Query("SELECT NEW com.manhattan.models.AuthorAndTotalBooksModel(concat(a.firstName, ' ', a.lastName), sum(b.copies))" +
            "FROM Author a JOIN a.books b " +
            "GROUP BY a " +
            "ORDER BY sum(b.copies) DESC ")
    List<AuthorAndTotalBooksModel> allAllWithTotalBooksCount();

    @Procedure(name="udp_get_books_count_by_author")
    int getBooksCountByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName);
}
