package io.github.todorkrastev.coffeeshop.service.impl;

import io.github.todorkrastev.coffeeshop.model.entity.Order;
import io.github.todorkrastev.coffeeshop.model.service.OrderServiceModel;
import io.github.todorkrastev.coffeeshop.model.view.OrderViewModel;
import io.github.todorkrastev.coffeeshop.repository.OrderRepository;
import io.github.todorkrastev.coffeeshop.service.CategoryService;
import io.github.todorkrastev.coffeeshop.service.OrderService;
import io.github.todorkrastev.coffeeshop.service.UserService;
import io.github.todorkrastev.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = this.modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(this.userService.findById(this.currentUser.getId()));
        order.setCategory(this.categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        this.orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersByPriceDesc() {
        return this.orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> this.modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        this.orderRepository
                .deleteById(id);
    }
}
