package io.github.todorkrastev.pathfinder.service;

import io.github.todorkrastev.pathfinder.model.service.RouteServiceModel;
import io.github.todorkrastev.pathfinder.model.view.RouteDetailsViewModel;
import io.github.todorkrastev.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
