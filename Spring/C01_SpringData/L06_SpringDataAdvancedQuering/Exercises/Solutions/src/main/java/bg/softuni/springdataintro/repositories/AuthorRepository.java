package bg.softuni.springdataintro.repositories;

import bg.softuni.springdataintro.models.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
