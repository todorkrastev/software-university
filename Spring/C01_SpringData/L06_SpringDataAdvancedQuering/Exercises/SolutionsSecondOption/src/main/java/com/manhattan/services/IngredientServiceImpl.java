package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ingredient> selectNameStartsWith(String nameStart) {
        return this.repository.findAllByNameStartingWith(nameStart);
    }

    @Override
    public List<Ingredient> selectNameIn(Set<String> names) {
        return this.repository.findAllByNameInOrderByPriceAsc(names);
    }

    @Override
    public int deleteByName(String s) {
        return this.repository.deleteByName(s);
    }

    @Override
    public int increasePriceByPercent(int percent) {
        return this.repository.updateAllBy(percent);
    }

    @Override
    public int increasePriceOfIngredientsByPercent(Set<String> names, int percent) {
        return this.repository.updateAllInList(names, percent);
    }


}
