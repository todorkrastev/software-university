package bg.manhattan.shoppinglist.service.impl;

import bg.manhattan.shoppinglist.model.entity.Category;
import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;
import bg.manhattan.shoppinglist.repository.CategoryRepository;
import bg.manhattan.shoppinglist.service.CategoryService;
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
