package bg.manhattan.shoppinglist.web;

import bg.manhattan.shoppinglist.model.binding.ProductAddBindingModel;
import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;
import bg.manhattan.shoppinglist.model.service.ProductServiceModel;
import bg.manhattan.shoppinglist.service.ProductService;
import bg.manhattan.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private final UserService userService;

    private final ModelMapper mapper;

    public ProductController(ProductService productService,
                             UserService userService,
                             ModelMapper modelMapper) {
        this.productService = productService;
        this.userService = userService;
        this.mapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("category")) {
            addCategories(model);
        }
        return "product-add";
    }

    private void addCategories(Model model) {
        model.addAttribute("categories", CategoryNameEnum.values());
    }

    @PostMapping("/add")
    public String add(@Valid ProductAddBindingModel productModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productModel", productModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productModel", bindingResult);
            return "redirect:add";
        }

        this.productService.addProduct(this.mapper.map(productModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        this.productService.buyProduct(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        this.productService.buyAllProducts();
        return "redirect:/";
    }

    @ModelAttribute("productModel")
    public ProductAddBindingModel initProductModel() {
        return new ProductAddBindingModel();
    }
}
