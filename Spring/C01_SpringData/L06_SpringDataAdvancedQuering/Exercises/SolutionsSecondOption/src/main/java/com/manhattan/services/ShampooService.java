package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size size, long id);

    List<Shampoo> selectByPriceGreaterThan(BigDecimal price);

    Long countPrice(BigDecimal price);

    List<String> shampooByIngredients(Set<String> ingredientNames);

    List<String> shampooByIngredientsCount(int ingredientsCount);
}
