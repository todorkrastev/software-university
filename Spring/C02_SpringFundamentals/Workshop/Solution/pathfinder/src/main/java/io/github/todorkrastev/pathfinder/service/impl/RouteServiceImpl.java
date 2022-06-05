package io.github.todorkrastev.pathfinder.service.impl;

import io.github.todorkrastev.pathfinder.model.entity.Route;
import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;
import io.github.todorkrastev.pathfinder.model.service.RouteServiceModel;
import io.github.todorkrastev.pathfinder.model.view.RouteDetailsViewModel;
import io.github.todorkrastev.pathfinder.model.view.RouteViewModel;
import io.github.todorkrastev.pathfinder.repository.RouteRepository;
import io.github.todorkrastev.pathfinder.service.CategoryService;
import io.github.todorkrastev.pathfinder.service.RouteService;
import io.github.todorkrastev.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return this.routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = this.modelMapper.map(route, RouteViewModel.class);

                    if (route.getPictures().stream().findAny().isPresent()) {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findAny().get().getUrl());
                    } else {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    }

                    return routeViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = this.modelMapper.map(routeServiceModel, Route.class);
        route.setLevelEnum(LevelName.valueOf(routeServiceModel.getLevel().name()));
        route.setAuthor(this.userService.findCurrentLoginUserEntity());

        route
                .setCategories(routeServiceModel
                        .getCategories()
                        .stream()
                        .map(categoryName -> this.categoryService.findCategoryByName(categoryName))
                        .collect(Collectors.toSet()));

        this.routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {
        return this.routeRepository
                .findById(id)
                .map(route -> this.modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
