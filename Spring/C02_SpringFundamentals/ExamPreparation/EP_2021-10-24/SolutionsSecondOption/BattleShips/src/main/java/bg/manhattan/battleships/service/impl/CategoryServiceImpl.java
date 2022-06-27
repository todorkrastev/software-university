package bg.manhattan.battleships.service.impl;


import bg.manhattan.battleships.model.entity.Category;
import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;
import bg.manhattan.battleships.repository.CategoryRepository;
import bg.manhattan.battleships.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Category> findByName(CategoryNameEnum category) {
        return this.repository.findByName(category);
    }
}
