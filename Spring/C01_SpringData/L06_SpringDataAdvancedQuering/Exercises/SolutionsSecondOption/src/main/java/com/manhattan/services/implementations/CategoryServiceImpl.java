package com.manhattan.services.implementations;

import com.manhattan.entities.Category;
import com.manhattan.repositories.CategoryRepository;
import com.manhattan.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerCategory(Category category) {
        if (!this.repository.existsByName(category.getName())) {
            this.repository.save(category);
        }
    }

    public Set<Category> getRandomCategories() {
        int size = (int) this.repository.count();
        Random random = new Random();
        List<Integer> categoryIds = new ArrayList<>();
        IntStream.range(0, random.nextInt(size) + 1)
                .map(i -> random.nextInt(size) + 1)
                .forEach(categoryIds::add);
        return new HashSet<>(this.repository.findAllById(categoryIds));
    }
}
