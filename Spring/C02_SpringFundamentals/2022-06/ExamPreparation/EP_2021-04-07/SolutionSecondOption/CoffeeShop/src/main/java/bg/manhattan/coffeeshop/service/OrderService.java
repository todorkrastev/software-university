package bg.manhattan.coffeeshop.service;

import bg.manhattan.coffeeshop.model.service.OrderServiceModel;
import bg.manhattan.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    OrderServiceModel addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> getAllOrdersOrderedByPriceDesc();

    void setOrderReady(Long id);
}
