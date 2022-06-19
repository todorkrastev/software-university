package com.todorkrastev.andreysstore.service.impl;

import com.todorkrastev.andreysstore.model.entity.Item;
import com.todorkrastev.andreysstore.model.service.ItemServiceModel;
import com.todorkrastev.andreysstore.model.view.ItemViewModel;
import com.todorkrastev.andreysstore.repository.ItemRepository;
import com.todorkrastev.andreysstore.service.CategoryService;
import com.todorkrastev.andreysstore.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        Item item = this.modelMapper
                .map(itemServiceModel, Item.class);

        item.setCategory(this.categoryService
                .find(itemServiceModel.getCategory().getCategoryName()));

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String
                            .format("/img/%s-%s.jpg",
                                    item.getGender(),
                                    item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository
                .findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String
                            .format("/img/%s-%s.jpg",
                                    item.getGender(),
                                    item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository
                .deleteById(id);
    }
}
