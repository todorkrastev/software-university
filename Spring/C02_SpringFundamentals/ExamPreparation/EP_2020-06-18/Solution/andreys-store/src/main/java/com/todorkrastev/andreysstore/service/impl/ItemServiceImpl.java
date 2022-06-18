package com.todorkrastev.andreysstore.service.impl;

import com.todorkrastev.andreysstore.model.entity.Item;
import com.todorkrastev.andreysstore.model.service.CategoryServiceModel;
import com.todorkrastev.andreysstore.model.service.ItemServiceModel;
import com.todorkrastev.andreysstore.repository.ItemRepository;
import com.todorkrastev.andreysstore.service.CategoryService;
import com.todorkrastev.andreysstore.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        CategoryServiceModel categoryServiceModel = this.categoryService
                .findByCategoryName(itemServiceModel
                        .getCategory().getCategoryName());

        itemServiceModel.setCategory(categoryServiceModel);

        this.itemRepository.saveAndFlush(this.modelMapper
                .map(itemServiceModel, Item.class));
    }
}
