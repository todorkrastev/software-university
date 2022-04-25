package com.manhattan.services.productShop.implementations;

import com.manhattan.models.productsShop.dtos.CategoriesByProductsDto;
import com.manhattan.models.productsShop.entities.Category;
import com.manhattan.repositories.productShop.CategoryRepository;
import com.manhattan.services.productShop.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;


    public CategoryServiceImpl(CategoryRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Set<Category> getRandomCategories() {
        int catCount = ThreadLocalRandom.current().nextInt(1, 3);
        long catTotalCount = this.repository.count();
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < catCount; i++) {
            long getId = ThreadLocalRandom.current().nextLong(1, catTotalCount + 1);
            Category e = this.repository.findById(getId).orElse(null);
            categories.add(e);
        }

        return categories;
    }

    @Override
    public void saveAll(Iterable<Category> categories) {
        this.repository.saveAllAndFlush(categories);
    }

    @Override
    public List<CategoriesByProductsDto> getCategoriesOrderByNumberOfProducts() {
        return this.repository.findAllOrderByProductCount()
                .stream()
                .map(cat->mapper.map(cat, CategoriesByProductsDto.class))
                .collect(Collectors.toList());
    }
}
