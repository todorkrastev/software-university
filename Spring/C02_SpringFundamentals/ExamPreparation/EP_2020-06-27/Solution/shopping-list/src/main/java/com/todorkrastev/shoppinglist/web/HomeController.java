package com.todorkrastev.shoppinglist.web;

import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;
import com.todorkrastev.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", this.productService.findAllProductsByCategoryName(CategoryName.DRINK));
        model.addAttribute("food", this.productService.findAllProductsByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", this.productService.findAllProductsByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", this.productService.findAllProductsByCategoryName(CategoryName.OTHER));


        return "home";
    }
}
