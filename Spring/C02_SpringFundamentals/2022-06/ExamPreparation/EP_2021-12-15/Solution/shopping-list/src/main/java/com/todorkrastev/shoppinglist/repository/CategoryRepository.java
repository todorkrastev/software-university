package com.todorkrastev.shoppinglist.repository;

import com.todorkrastev.shoppinglist.model.entity.Category;
import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoryName name);
}
