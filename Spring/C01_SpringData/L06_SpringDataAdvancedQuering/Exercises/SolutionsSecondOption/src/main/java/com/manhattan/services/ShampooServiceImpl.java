package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService{
    private final ShampooRepository repository;

    public ShampooServiceImpl(ShampooRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Shampoo> selectBySize(Size size) {
        return repository.findAllBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, long id) {
        return repository.findAllBySizeOrLabelIdOrderByPriceAsc(size,id);
    }

    @Override
    public List<Shampoo> selectByPriceGreaterThan(BigDecimal price) {
        return repository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long countPrice(BigDecimal price) {
        return this.repository.countAllByPriceLessThan(price);
    }

    @Override
    public List<String> shampooByIngredients(Set<String> ingredientNames) {
        return this.repository.findAllByIngredientsNames(ingredientNames);
    }

    @Override
    public List<String> shampooByIngredientsCount(int ingredientsCount) {
        return this.repository.findAllWithIngredientsCountLessThan(ingredientsCount);
    }
}
