package bg.manhattan.battleships.service.impl;

import bg.manhattan.battleships.model.entity.Category;
import bg.manhattan.battleships.model.entity.Ship;
import bg.manhattan.battleships.model.entity.User;
import bg.manhattan.battleships.model.service.ShipFireServiceModel;
import bg.manhattan.battleships.model.service.ShipServiceModel;
import bg.manhattan.battleships.model.service.UserServiceModel;
import bg.manhattan.battleships.model.view.ShipListViewModel;
import bg.manhattan.battleships.repository.ShipRepository;
import bg.manhattan.battleships.service.CategoryService;
import bg.manhattan.battleships.service.ShipService;
import bg.manhattan.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository repository;

    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper mapper;

    public ShipServiceImpl(ShipRepository repository,
                           UserService userService,
                           CategoryService categoryService,
                           ModelMapper mapper) {
        this.repository = repository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @Override
    public void addShip(ShipServiceModel shipModel) {
        User user = this.userService.getCurrentUser()
                .orElseThrow(()->new IllegalArgumentException(
                        String.format("User [%s] not found!",
                        this.userService.getCurrentUserName())));

        Category category = this.categoryService.findByName(shipModel.getCategory())
                .orElseThrow(()->new IllegalArgumentException(
                        String.format("Category [%s] not found!", shipModel.getCategory())));


        Ship ship = this.mapper.map(shipModel, Ship.class)
                .setCategory(category)
                .setUser(user);

        this.repository.save(ship);

    }

    @Override
    public ShipListViewModel getAllShips() {
        return new ShipListViewModel(this.repository.findAllShips(), this.userService.getCurrentUserName());
    }

    @Override
    public void fire(ShipFireServiceModel fireModel) {
        Ship attacker = this.repository.findById(fireModel.getAttackerId())
                .orElseThrow(()->new IllegalArgumentException(String.format("Ship id: %d not found!", fireModel.getAttackerId())));
        Ship defender = this.repository.findById(fireModel.getDefenderId())
                .orElseThrow(()->new IllegalArgumentException(String.format("Ship id: %d not found!",
                        fireModel.getDefenderId())));

        defender.setHealth(defender.getHealth() - attacker.getPower());

        if (defender.getHealth() <= 0){
            this.repository.delete(defender);
        } else {
            this.repository.save(defender);
        }
    }

    @Override
    public Optional<Ship> findByName(String shipName) {
        return this.repository.findByName(shipName);
    }
}
