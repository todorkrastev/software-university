package bg.manhattan.coffeeshop.service.impl;

import bg.manhattan.coffeeshop.model.entity.Category;
import bg.manhattan.coffeeshop.model.enums.CategoryName;
import bg.manhattan.coffeeshop.repository.CategoryRepository;
import bg.manhattan.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seed() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryName.values())
                .map(categoryName ->
                        new Category()
                                .setName(categoryName)
                                .setNeededTime(categoryName.getCategoryTime()))
                .forEach(category -> categoryRepository.save(category));

    }

    @Override
    public Category getByCategoryName(CategoryName category) {
        return this.categoryRepository
                .findByName(category)
                .orElse(null);
    }
}
