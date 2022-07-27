package com.todorkrastev.andreysstore.service;

import com.todorkrastev.andreysstore.model.service.ItemServiceModel;
import com.todorkrastev.andreysstore.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
