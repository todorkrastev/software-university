package io.github.todorkrastev.coffeeshop.web;

import io.github.todorkrastev.coffeeshop.model.view.OrderViewModel;
import io.github.todorkrastev.coffeeshop.service.OrderService;
import io.github.todorkrastev.coffeeshop.service.UserService;
import io.github.todorkrastev.coffeeshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {

        if (this.currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = this.orderService.findAllOrdersByPriceDesc();

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0));


        model.addAttribute("users", this.userService.findAllUsersByCountOfOrdersOrderedByCountDesc());

        return "home";
    }
}
