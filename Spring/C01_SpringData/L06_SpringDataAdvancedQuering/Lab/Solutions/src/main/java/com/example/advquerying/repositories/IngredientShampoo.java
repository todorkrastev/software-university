package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientShampoo extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameIsStartingWith(char letter);
}
