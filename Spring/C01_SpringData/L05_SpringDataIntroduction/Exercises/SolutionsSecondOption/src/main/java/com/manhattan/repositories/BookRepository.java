package com.manhattan.repositories;

import com.manhattan.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> findDistinctAllByReleaseDateAfter(LocalDate date);

    Set<Book> findDistinctAllByReleaseDateBefore(LocalDate date);

    List<Book> getAllTest();
}
