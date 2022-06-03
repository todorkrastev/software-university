package io.github.todorkrastev.coffeeshop.service;

import io.github.todorkrastev.coffeeshop.model.service.OrderServiceModel;
import io.github.todorkrastev.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDesc();

    void readyOrder(Long id);
}
