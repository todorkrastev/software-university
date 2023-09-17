package bg.manhattan.battleships.web;

import bg.manhattan.battleships.model.binding.FireBindingModel;
import bg.manhattan.battleships.model.binding.ShipAddBindingModel;
import bg.manhattan.battleships.model.service.ShipFireServiceModel;
import bg.manhattan.battleships.model.service.UserServiceModel;
import bg.manhattan.battleships.model.view.ShipListViewModel;
import bg.manhattan.battleships.service.ShipService;
import bg.manhattan.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {
    private final UserService userService;
    private final ShipService shipService;

    private final ModelMapper mapper;


    public HomeController(UserService userService,
                          ShipService shipService,
                          ModelMapper mapper) {
        this.userService = userService;
        this.shipService = shipService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            model.addAttribute("ships", this.shipService.getAllShips());
            return "home";
        }

        return "index";
    }

    @PostMapping("/")
    public String register(@Valid FireBindingModel fireModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return getErrorResponse(fireModel, bindingResult, redirectAttributes);
        }

        try {
            this.shipService.fire(this.mapper.map(fireModel, ShipFireServiceModel.class));
        } catch (IllegalArgumentException ex){
            ObjectError error = new ObjectError("globalError", ex.getMessage());
            bindingResult.addError(error);
            return getErrorResponse(fireModel, bindingResult, redirectAttributes);
        }
        return "redirect:/";
    }

    private String getErrorResponse(FireBindingModel fireModel, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("fireModel", fireModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.fireModel", bindingResult);
        return "redirect:/";
    }

    @ModelAttribute("fireModel")
    public FireBindingModel initFireModel(){
        return new FireBindingModel();
    }
}
