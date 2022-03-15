package bg.softuni.gamestore.services.implementations;

import bg.softuni.gamestore.models.entities.User;
import bg.softuni.gamestore.repositories.OrderRepository;
import bg.softuni.gamestore.services.OrderService;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }
}
