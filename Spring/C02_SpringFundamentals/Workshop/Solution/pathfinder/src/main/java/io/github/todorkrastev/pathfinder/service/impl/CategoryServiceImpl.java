package io.github.todorkrastev.pathfinder.service.impl;

import io.github.todorkrastev.pathfinder.model.entity.Category;
import io.github.todorkrastev.pathfinder.model.entity.enums.CategoryName;
import io.github.todorkrastev.pathfinder.repository.CategoryRepository;
import io.github.todorkrastev.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryName name) {
        return this.categoryRepository
                .findByName(name)
                .orElse(null);

    }
}
