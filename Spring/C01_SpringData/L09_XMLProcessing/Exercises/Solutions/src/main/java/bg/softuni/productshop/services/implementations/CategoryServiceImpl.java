package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.models.dtos.CategorySeedDto;
import bg.softuni.productshop.models.dtos.CategoryViewRootDto;
import bg.softuni.productshop.models.dtos.CategoryViewWithProductsCountAvgPriceAndTotalRevenue;
import bg.softuni.productshop.models.entities.Category;
import bg.softuni.productshop.models.entities.Product;
import bg.softuni.productshop.repositories.CategoryRepository;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        int categoriesCounter = ThreadLocalRandom.current().nextInt(1, 4);

        for (int i = 0; i < categoriesCounter; i++) {
            long randomId = ThreadLocalRandom
                    .current()
                    .nextLong(1, this.categoryRepository.count() + 1);

            Category category = this.categoryRepository
                    .findById(randomId)
                    .orElse(null);

            categories.add(category);
        }

        return categories;
    }

    @Override
    public CategoryViewRootDto getAllCategoriesOrderByNumberOfProducts() {
        CategoryViewRootDto categoryViewRootDto = new CategoryViewRootDto();

        List<CategoryViewWithProductsCountAvgPriceAndTotalRevenue> categories = this.categoryRepository
                .findAllOrderedByProductsCountDesc()
                .stream()
                .map(category -> this.modelMapper.map(category, CategoryViewWithProductsCountAvgPriceAndTotalRevenue.class))
                .collect(Collectors.toList());

        categoryViewRootDto.setCategories(categories);

        return categoryViewRootDto;
    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
    }
}
