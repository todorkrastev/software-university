package bg.manhattan.coffeeshop.web;

import bg.manhattan.coffeeshop.model.view.OrderViewModel;
import bg.manhattan.coffeeshop.security.CurrentUser;
import bg.manhattan.coffeeshop.service.OrderService;
import bg.manhattan.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {
    private final OrderService orderService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public HomeController(OrderService orderService, UserService userService, CurrentUser currentUser) {
        this.orderService = orderService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = this.orderService.getAllOrdersOrderedByPriceDesc();
        model.addAttribute("orders", orders);
        model.addAttribute("usersOrders", this.userService.getOrdersUsersWithTheirOrdersCountOrderByCountDesc());
        model.addAttribute("totalTime",
                orders
                        .stream()
                        .map(OrderViewModel::getPrepareTime)
                        .reduce((sum, orderPrepareTime) -> sum += orderPrepareTime)
                        .orElse(null));

        return "home";
    }
}
