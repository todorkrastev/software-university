package io.github.todorkrastev.pathfinder.web;

import io.github.todorkrastev.pathfinder.model.binding.RouteAddBindingModel;
import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;
import io.github.todorkrastev.pathfinder.model.service.RouteServiceModel;
import io.github.todorkrastev.pathfinder.service.RouteService;
import io.github.todorkrastev.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        model.addAttribute("routes", this.routeService
                .findAllRoutesView());

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        model.addAttribute("route", routeService.findRouteById(id));


        return "route-details";
    }

    @GetMapping("/add")
    public String add() {

        if (this.currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel", bindingResult);

            return "redirect:add";
        }

        RouteServiceModel routeServiceModel = this.modelMapper
                .map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel
                .setLevel(LevelName.valueOf(routeAddBindingModel.getLevel().name()));
        routeServiceModel
                .setGpxCoordinates(new String(routeAddBindingModel
                        .getGpxCoordinates()
                        .getBytes()));

        this.routeService.addNewRoute(routeServiceModel);

        return "redirect:all";
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }
}
