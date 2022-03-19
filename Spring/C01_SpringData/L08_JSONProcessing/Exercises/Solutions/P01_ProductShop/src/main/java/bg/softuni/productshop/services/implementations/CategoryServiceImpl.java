package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.constants.GlobalConstant;
import bg.softuni.productshop.models.dtos.CategoriesByProductsDto;
import bg.softuni.productshop.models.dtos.CategorySeedDto;
import bg.softuni.productshop.models.entities.Category;
import bg.softuni.productshop.repositories.CategoryRepository;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    public static final String CATEGORIES_FILE_NAME = "categories.json";
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() == 0) {
            String fileContent = Files
                    .readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));

            CategorySeedDto[] categorySeedDtos = this.gson
                    .fromJson(fileContent, CategorySeedDto[].class);

            Arrays.stream(categorySeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                    .forEach(this.categoryRepository::save);
        }
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int catCount = ThreadLocalRandom
                .current()
                .nextInt(1, 4);
        long totalCategoriesCount = this.categoryRepository.count();

        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom
                    .current()
                    .nextLong(1, totalCategoriesCount + 1);

            categories.add(this.categoryRepository
                    .findById(randomId)
                    .orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoriesByProductsDto> getAllCategoriesOrderByNumberOfProducts() {
        return this.categoryRepository
                .findAllOrderByProductCount()
                .stream()
                .map(categoriesByProductsDto -> modelMapper.map(categoriesByProductsDto, CategoriesByProductsDto.class))
                .collect(Collectors.toList());
    }
}
