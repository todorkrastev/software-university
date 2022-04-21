package com.manhattan.services.productShop.implementations;

import com.manhattan.models.productsShop.dtos.CategoryRootDto;
import com.manhattan.models.productsShop.dtos.ProductSeedSoorDto;
import com.manhattan.models.productsShop.dtos.UserSeedRootDto;
import com.manhattan.models.productsShop.entities.Category;
import com.manhattan.models.productsShop.entities.Product;
import com.manhattan.models.productsShop.entities.User;
import com.manhattan.services.common.FileService;
import com.manhattan.services.productShop.interfaces.CategoryService;
import com.manhattan.services.productShop.interfaces.ProductService;
import com.manhattan.services.productShop.interfaces.SeedProductShopService;
import com.manhattan.services.productShop.interfaces.UserService;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.manhattan.utils.CommonConstants.*;

@Service
public class SeedProductShopServiceImpl implements SeedProductShopService {
    private final FileService fileService;
    private final ValidationsUtil validator;
    private final ModelMapper modelMapper;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    public SeedProductShopServiceImpl(FileService fileService,
                                      ValidationsUtil validator,
                                      ModelMapper modelMapper,
                                      ProductService productService,
                                      UserService userService,
                                      CategoryService categoryService) {
        this.fileService = fileService;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seed() throws IOException, JAXBException {
        if (this.categoryService.hasNoRecords()) seedCategories();
        if (this.userService.hasNoRecords()) seedUsers();
        if (this.productService.hasNoRecords()) seedProducts();
    }

    private void seedProducts() throws IOException, JAXBException {
        this.productService.saveAll(
                fileService
                        .readXmlFile(RESOURCE_FILE_PATH + PRODUCTS_FILE, ProductSeedSoorDto.class)
                        .getProducts()
                        .stream()
                        .filter(validator::isValid)
                        .map(prod -> modelMapper.map(prod, Product.class))
                        .map(prod -> {
                            prod.setSeller(this.userService.getRandomUser());
                            if (prod.getPrice().compareTo(BigDecimal.valueOf(800L)) < 0) {
                                prod.setBuyer(this.userService.getRandomUser());
                            }
                            prod.setCategories(this.categoryService.getRandomCategories());
                            return prod;
                        })
                        .collect(Collectors.toList())
        );
    }

    private void seedUsers() throws IOException, JAXBException {
        this.userService.saveAll(
                fileService.readXmlFile(RESOURCE_FILE_PATH + USERS_FILE, UserSeedRootDto.class)
                        .getUsers()
                        .stream()
                        .filter(validator::isValid)
                        .map(usr -> modelMapper.map(usr, User.class))
                        .collect(Collectors.toList())
        );
    }


    private void seedCategories() throws IOException, JAXBException {
        List<Category> categories = fileService
                .readXmlFile(RESOURCE_FILE_PATH + CATEGORIES_FILE, CategoryRootDto.class)
                .getCategories()
                .stream()
                .filter(validator::isValid)
                .map(cat -> modelMapper.map(cat, Category.class))
                .collect(Collectors.toList());
        this.categoryService.saveAll(
                categories
        );
    }
}
