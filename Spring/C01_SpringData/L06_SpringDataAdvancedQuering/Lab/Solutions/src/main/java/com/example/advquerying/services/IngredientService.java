package com.example.advquerying.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public interface IngredientService {
    void findAllIngredientsWhichNameStartsWithGivenLetter(String letters);

    void selectIngredientsByName(Set<String> names);

    int deleteIngredientByGivenName(String ingredient);

    int increasePriceByGivenPercentage(BigDecimal percentage);

    int increasePricesWithGivenPercentageAndListOfNames(BigDecimal percentage, Collection<String> names);
}
