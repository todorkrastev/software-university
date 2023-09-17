package bg.manhattan.andreysshop.web;

import bg.manhattan.andreysshop.model.binding.ProductAddBindingModel;
import bg.manhattan.andreysshop.model.service.ProductServiceModel;
import bg.manhattan.andreysshop.model.view.ProductDetailsViewModel;
import bg.manhattan.andreysshop.service.ProductService;
import bg.manhattan.andreysshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final UserService userService;
    private final ProductService productService;
    private final ModelMapper mapper;

    public ProductController(UserService userService,
                             ProductService productService,
                             ModelMapper modelMapper) {
        this.userService = userService;
        this.productService = productService;
        this.mapper = modelMapper;
    }

    @GetMapping("add")
    public String add() {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        return "add-product";
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

        this.productService.add(this.mapper.map(productModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable UUID id, Model model) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        Optional<ProductDetailsViewModel> productDetailModel = this.productService.getById(id);
        if (productDetailModel.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("productDetailModel", productDetailModel.get());
        return "details-product";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        this.productService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute("productModel")
    public ProductAddBindingModel initProduct() {
        return new ProductAddBindingModel();
    }

}
