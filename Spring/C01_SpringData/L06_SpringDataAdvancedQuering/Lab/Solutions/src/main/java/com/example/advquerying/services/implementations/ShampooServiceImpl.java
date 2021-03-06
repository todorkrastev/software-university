package com.example.advquerying.services.implementations;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void findAllShampoosByGivenSizeOrderedByShampooId(Size size) {
        this.shampooRepository
                .findAllBySizeOrderById(size)
                .forEach(shampoo -> System.out.printf("%s %s %.2flv.%n",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()));
    }

    @Override
    public void findAllShampoosByGivenSizeOrLabel(Size size, int id) {
        this.shampooRepository
                .findAllBySizeOrLabelIdOrderByPriceAsc(size, id)
                .forEach(shampoo -> System.out.printf("%s %s %.2flv.%n",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()));
    }

    @Override
    public void findAllShampoosWhichPriceIsHigherThanGivenOne(BigDecimal price) {
        this.shampooRepository
                .findByPriceGreaterThanOrderByPriceDesc(price)
                .forEach(shampoo -> System.out.printf("%s %s %.2flv.%n",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()));
    }

    @Override
    public int countAllShampoosWithPriceLowerThanGivenOne(BigDecimal price) {
        return this.shampooRepository
                .countByPriceLessThan(price);
    }

    @Override
    public void findAllShampoosByGivenListWithIngredients(Set<String> ingredients) {
        this.shampooRepository
                .findByIngredientsNames(ingredients)
                .forEach(ingredient -> System.out.println(ingredient.getBrand()));
    }

    @Override
    public void findAllShampoosWithIngredientsLessThanGivenNumber(int number) {
        this.shampooRepository
                .findByIngredientCountLessThan(number)
                .forEach(shampoo -> System.out.println(shampoo.getBrand()));
    }
}
