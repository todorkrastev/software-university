package com.todorkrastev.andreysstore.repository;

import com.todorkrastev.andreysstore.model.entity.Category;
import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCategoryName(CategoryName categoryName);
}
