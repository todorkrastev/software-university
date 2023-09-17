package bg.manhattan.coffeeshop.web;

import bg.manhattan.coffeeshop.model.binding.OrderAddBindingModel;
import bg.manhattan.coffeeshop.model.service.OrderServiceModel;
import bg.manhattan.coffeeshop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper mapper;

    public OrderController(OrderService orderService,
                           ModelMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid OrderAddBindingModel orderModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderModel", orderModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderModel", bindingResult);
            return "redirect:add";
        }

        this.orderService.addOrder(this.mapper.map(orderModel, OrderServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        this.orderService.setOrderReady(id);
        return "redirect:/";
    }

    @ModelAttribute("orderModel")
    public OrderAddBindingModel initOrderModel() {
        return new OrderAddBindingModel();
    }

}
