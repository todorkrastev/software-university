package com.example.advquerying.services.implementations;

import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.services.IngredientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void findAllIngredientsWhichNameStartsWithGivenLetter(String letters) {
        this.ingredientRepository
                .findAllByNameIsStartingWith(letters)
                .forEach(ingredient -> System.out.printf("%s%n", ingredient.getName()));
    }

    @Override
    public void selectIngredientsByName(Set<String> names) {
        this.ingredientRepository
                .findAllByNameInOrderByPriceAsc(names)
                .forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    @Override
    @Transactional
    public int deleteIngredientByGivenName(String ingredient) {
        return this.ingredientRepository
                .deleteIngredientByName(ingredient);
    }

    @Override
    @Transactional
    public int increasePriceByGivenPercentage(BigDecimal percentage) {
        return this.ingredientRepository
                .increasePriceByPercentage(percentage);
    }

    @Override
    @Transactional
    public int increasePricesWithGivenPercentageAndListOfNames(BigDecimal percentage, Collection<String> names) {
        return this.ingredientRepository
                .increasePricesWithGivenPercentageAndListOfNames(percentage, names);
    }
}
