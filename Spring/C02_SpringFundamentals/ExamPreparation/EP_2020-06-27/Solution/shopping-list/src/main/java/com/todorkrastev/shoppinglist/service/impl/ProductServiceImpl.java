package com.todorkrastev.shoppinglist.service.impl;

import com.todorkrastev.shoppinglist.model.entity.Product;
import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;
import com.todorkrastev.shoppinglist.model.service.ProductServiceModel;
import com.todorkrastev.shoppinglist.model.view.ProductViewModel;
import com.todorkrastev.shoppinglist.repository.ProductRepository;
import com.todorkrastev.shoppinglist.service.CategoryService;
import com.todorkrastev.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setCategory(this.categoryService
                .findByName(productServiceModel.getCategory()));

        this.productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return this.productRepository.findProductsByTotalSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName) {
        return this.productRepository
                .findAllByCategory_Name(categoryName)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }
}
