package com.manhattan.repositories;

import com.manhattan.entities.Author;
import com.manhattan.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Author findByFirstNameAndLastName(String firstName, String lastName);
}
