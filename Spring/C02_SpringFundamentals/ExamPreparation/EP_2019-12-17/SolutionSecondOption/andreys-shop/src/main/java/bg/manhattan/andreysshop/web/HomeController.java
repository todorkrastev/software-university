package bg.manhattan.andreysshop.web;


import bg.manhattan.andreysshop.model.view.HomeViewModel;
import bg.manhattan.andreysshop.service.ProductService;
import bg.manhattan.andreysshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;

    private final ProductService productService;

    public HomeController(UserService userService,
                          ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            if (!model.containsAttribute("homeModel")) {
                HomeViewModel homeViewModel = new HomeViewModel(this.productService.getProducts());
                model.addAttribute("homeModel", homeViewModel);
            }
            return "home";
        }

        return "index";
    }
}
