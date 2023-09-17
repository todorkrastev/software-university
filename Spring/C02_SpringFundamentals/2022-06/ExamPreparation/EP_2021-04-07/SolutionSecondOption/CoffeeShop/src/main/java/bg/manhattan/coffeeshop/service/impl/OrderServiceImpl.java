package bg.manhattan.coffeeshop.service.impl;

import bg.manhattan.coffeeshop.model.entity.Order;
import bg.manhattan.coffeeshop.model.service.OrderServiceModel;
import bg.manhattan.coffeeshop.model.view.OrderViewModel;
import bg.manhattan.coffeeshop.repository.OrderRepository;
import bg.manhattan.coffeeshop.security.CurrentUser;
import bg.manhattan.coffeeshop.service.CategoryService;
import bg.manhattan.coffeeshop.service.OrderService;
import bg.manhattan.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;
private final CategoryService categoryService;
    private final CurrentUser currentUser;

    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ModelMapper mapper,
                            CategoryService categoryService,
                            CurrentUser currentUser,
                            UserService userService) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public OrderServiceModel addOrder(OrderServiceModel orderServiceModel) {
        Order order = this.mapper.map(orderServiceModel, Order.class);
        order.setEmployee(this.userService.getUserById(currentUser.getId()));
        order.setCategory(this.categoryService.getByCategoryName(orderServiceModel.getCategory()));

        Order dbOrder = this.orderRepository.save(order);
        return this.mapper.map(dbOrder, OrderServiceModel.class);
    }

    @Override
    public List<OrderViewModel> getAllOrdersOrderedByPriceDesc() {
        return this.orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order->this.mapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void setOrderReady(Long id) {
        this.orderRepository.deleteById(id);
    }
}
