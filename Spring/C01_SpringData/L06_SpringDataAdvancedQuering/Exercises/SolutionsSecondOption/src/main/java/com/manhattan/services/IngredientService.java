package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientService {
    List<Ingredient> selectNameStartsWith(String nameStart);
    List<Ingredient> selectNameIn(Set<String> names);
    int deleteByName(String s);

    int increasePriceByPercent(int i);

    int increasePriceOfIngredientsByPercent(Set<String> names, int i);
}
