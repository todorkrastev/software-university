package bg.manhattan.heroes.web;


import bg.manhattan.heroes.model.view.HeroViewModel;
import bg.manhattan.heroes.service.HeroService;
import bg.manhattan.heroes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final UserService userService;
    private final HeroService heroService;
    private final ModelMapper mapper;

    public HomeController(UserService userService,
                          HeroService heroService,
                          ModelMapper mapper) {
        this.userService = userService;
        this.heroService = heroService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            if (!model.containsAttribute("homeModel")) {
                List<HeroViewModel> heroes = this.heroService.getAllHeroesByLevelDesc()
                        .stream()
                        .map(hero -> this.mapper.map(hero, HeroViewModel.class))
                        .collect(Collectors.toList());

                model.addAttribute("heroes", heroes);
            }
            return "home";
        }

        return "index";
    }
}
