package com.example.advquerying.services;

import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.Set;


public interface ShampooService {
    void findAllShampoosByGivenSizeOrderedByShampooId(Size size);

    void findAllShampoosByGivenSizeOrLabel(Size size, int id);

    void findAllShampoosWhichPriceIsHigherThanGivenOne(BigDecimal price);

    int countAllShampoosWithPriceLowerThanGivenOne(BigDecimal price);

    void findAllShampoosByGivenListWithIngredients(Set<String> ingredients);

    void findAllShampoosWithIngredientsLessThanGivenNumber(int number);
}
