package bg.manhattan.shoppinglist.web;

import bg.manhattan.shoppinglist.service.ProductService;
import bg.manhattan.shoppinglist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;
    private final ProductService productService;

    public HomeController(UserService userService, ProductService productService) {
        this.userService = userService;

        this.productService = productService;
    }

    @GetMapping
    public String index(Model model){
        if (this.userService.isLoggedIn()){
            model.addAttribute("products", this.productService.getProducts());
            return "home";
        }

        return "index";
    }
}
