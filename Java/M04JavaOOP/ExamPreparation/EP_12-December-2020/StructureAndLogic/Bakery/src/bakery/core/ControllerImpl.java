package bakery.core;

import static bakery.common.OutputMessages.*;
import static bakery.common.ExceptionMessages.*;

import bakery.common.enums.BakedFoodType;
import bakery.common.enums.DrinkType;
import bakery.common.enums.TableTYpe;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {


    private final FoodRepository<BakedFood> foodRepository;
    private final DrinkRepository<Drink> drinkRepository;
    private final TableRepository<Table> tableRepository;

    private double totalBills;
    private BakedFood food;
    private Drink drink;
    private Table table;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;

    }

    @Override
    public String addFood(String type, String name, double price) {

        if (this.foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (BakedFoodType.valueOf(type)) {
            case Bread:
                food = new Bread(name, price);
                break;
            case Cake:
                food = new Cake(name, price);
                break;
        }

        foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        if (this.drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (DrinkType.valueOf(type)) {
            case Tea:
                drink = new Tea(name, portion, brand);
                break;
            case Water:
                drink = new Water(name, portion, brand);
                break;
        }

        drinkRepository.add(drink);

        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        if (this.tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        switch (TableTYpe.valueOf(type)) {
            case InsideTable:
                table = new InsideTable(tableNumber, capacity);
                break;
            case OutsideTable:
                table = new OutsideTable(tableNumber, capacity);
                break;
        }

        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        table = this.tableRepository
                .getAll().stream().filter(table -> (!table.isReserved())
                        && (table.getCapacity() >= numberOfPeople))
                .findFirst().orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);

    }

    @Override
    public String orderFood(int tableNumber, String foodName) {

        if (this.tableRepository.getByNumber(tableNumber) == null
                || !this.tableRepository.getByNumber(tableNumber).isReserved()) {

            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.foodRepository.getByName(foodName) == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        this.tableRepository.getByNumber(tableNumber).orderFood(this.foodRepository.getByName(foodName));
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {

        if (this.tableRepository.getByNumber(tableNumber) == null
                || !this.tableRepository.getByNumber(tableNumber).isReserved()) {

            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand) == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        this.tableRepository.getByNumber(tableNumber)
                .orderDrink(this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand));
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {

        double bill = this.tableRepository.getByNumber(tableNumber).getBill();
        totalBills = totalBills + bill;
        this.tableRepository.getByNumber(tableNumber).clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {

        StringBuilder out = new StringBuilder();

        List<Table> freeTables = this.tableRepository.getAll().stream()
                .filter(table -> !table.isReserved() && table.getNumberOfPeople() == 0)
                .collect(Collectors.toList());
        freeTables.forEach(e ->
                out.append(e.getFreeTableInfo()).append(System.lineSeparator()));

        return out.toString().trim();
    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, totalBills);
    }
}