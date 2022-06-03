package io.github.todorkrastev.coffeeshop.service.impl;

import io.github.todorkrastev.coffeeshop.model.entity.Category;
import io.github.todorkrastev.coffeeshop.model.entity.enums.CategoryName;
import io.github.todorkrastev.coffeeshop.repository.CategoryRepository;
import io.github.todorkrastev.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (this.categoryRepository.count() == 0) {

            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);

                        switch (categoryName) {
                            case CAKE -> category.setNeededTime(10);
                            case DRINK -> category.setNeededTime(1);
                            case COFFEE -> category.setNeededTime(2);
                            case OTHER -> category.setNeededTime(5);
                        }

                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryName name) {
        return this.categoryRepository
                .findByName(name)
                .orElse(null);
    }
}
