package bg.manhattan.coffeeshop.repository;

import bg.manhattan.coffeeshop.model.entity.Category;
import bg.manhattan.coffeeshop.model.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryName categoryName);
}
