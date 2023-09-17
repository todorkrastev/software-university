package com.todorkrastev.shoppinglist.service;

import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;
import com.todorkrastev.shoppinglist.model.service.ProductServiceModel;
import com.todorkrastev.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(String id);

    void buyAll();
}
