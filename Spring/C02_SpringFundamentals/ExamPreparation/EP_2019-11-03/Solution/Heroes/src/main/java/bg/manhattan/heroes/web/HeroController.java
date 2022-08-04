package bg.manhattan.heroes.web;

import bg.manhattan.heroes.model.binding.HeroBindingModel;
import bg.manhattan.heroes.model.binding.HeroDeleteBindingModel;
import bg.manhattan.heroes.model.service.HeroServiceModel;
import bg.manhattan.heroes.model.view.HeroDetailsViewModel;
import bg.manhattan.heroes.service.HeroService;
import bg.manhattan.heroes.service.UserService;
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
@RequestMapping("/heroes")
public class HeroController {
    private final UserService userService;
    private final HeroService heroService;

    private final ModelMapper mapper;

    public HeroController(UserService userService,
                          HeroService heroService,
                          ModelMapper mapper) {
        this.userService = userService;
        this.heroService = heroService;
        this.mapper = mapper;
    }

    @GetMapping("/create")
    public String create() {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/users/login";
        }
        return "create-hero";
    }

    @PostMapping("/create")
    public String create(@Valid HeroBindingModel heroModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroModel", heroModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroModel", bindingResult);
            return "redirect:create";
        }

        this.heroService.create(this.mapper.map(heroModel, HeroServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable UUID id, Model model) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        Optional<HeroDetailsViewModel> heroDetailModel = this.heroService.getById(id)
                .map(hero -> this.mapper.map(hero, HeroDetailsViewModel.class));

        if (heroDetailModel.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("heroDetailModel", heroDetailModel.get());
        return "details-hero";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(@PathVariable UUID id, Model model) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("heroDeleteModel")) {
            Optional<HeroServiceModel> hero = this.heroService.getById(id);
            if (hero.isEmpty()){
                return "redirect:/";
            }

            HeroDeleteBindingModel bindingModel = this.mapper.map(hero.get(), HeroDeleteBindingModel.class);
            model.addAttribute("heroDeleteModel", bindingModel);
        }

        return "delete-hero";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        if (!userService.isLoggedIn()) {
            return "redirect:/users/login";
        }

        this.heroService.deleteById(id);
        return "redirect:/";
    }

    @ModelAttribute("heroModel")
    public HeroBindingModel initHero() {
        return new HeroBindingModel();
    }
}
