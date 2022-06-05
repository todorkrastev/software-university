package io.github.todorkrastev.pathfinder.repository;

import io.github.todorkrastev.pathfinder.model.entity.Category;
import io.github.todorkrastev.pathfinder.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryName name);
}
