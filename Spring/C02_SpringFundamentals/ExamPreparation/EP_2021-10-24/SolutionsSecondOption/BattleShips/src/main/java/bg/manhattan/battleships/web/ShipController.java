package bg.manhattan.battleships.web;

import bg.manhattan.battleships.model.binding.ShipAddBindingModel;
import bg.manhattan.battleships.model.binding.UserLoginBindingModel;
import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;
import bg.manhattan.battleships.model.service.ShipServiceModel;
import bg.manhattan.battleships.service.ShipService;
import bg.manhattan.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final UserService userService;
    private final ShipService shipService;

    private final ModelMapper mapper;

    public ShipController(UserService userService,
                          ShipService shipService,
                          ModelMapper mapper) {
        this.userService = userService;
        this.shipService = shipService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String add() {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String add(@Valid ShipAddBindingModel shipModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            return getErrorResponse(shipModel, bindingResult, redirectAttributes);
        }

        try {
            this.shipService.addShip(this.mapper.map(shipModel, ShipServiceModel.class));
        } catch (IllegalArgumentException ex) {
            ObjectError error = new ObjectError("globalError", ex.getMessage());
            bindingResult.addError(error);
            return getErrorResponse(shipModel, bindingResult, redirectAttributes);
        }
        return "redirect:/";
    }

    private String getErrorResponse(ShipAddBindingModel shipModel, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("shipModel", shipModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipModel", bindingResult);
        return "redirect:add";
    }

    @ModelAttribute("shipModel")
    public ShipAddBindingModel initProductModel() {
        return new ShipAddBindingModel();
    }
}
