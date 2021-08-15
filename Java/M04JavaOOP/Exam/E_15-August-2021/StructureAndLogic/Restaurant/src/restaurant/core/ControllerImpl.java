package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;

    private double totalBills;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        if (this.healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }
        Food food = null;
        switch (type) {
            case "Salad":
                food = new Salad(name, price);
                break;
            case "VeganBiscuits":
                food = new VeganBiscuits(name, price);
                break;
        }
        if (food != null) {
            this.healthFoodRepository.add(food);
        }
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        if (this.beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }
        Beverages beverages = null;
        switch (type) {
            case "Fresh":
                beverages = new Fresh(name, counter, brand);
                break;
            case "Smoothie":
                beverages = new Smoothie(name, counter, brand);
                break;
        }
        if (beverages != null) {
            this.beverageRepository.add(beverages);
        }
        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (this.tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        Table table = null;
        switch (type) {
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                break;
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                break;
        }
        if (table != null) {
            this.tableRepository.add(table);
        }
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table availableTable = this.tableRepository
                .getAllEntities()
                .stream()
                .filter(table -> (!table.isReservedTable())
                        && (table.getSize() >= numberOfPeople))
                .findFirst()
                .orElse(null);

        if (availableTable == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        availableTable.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, availableTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        if (this.tableRepository.byNumber(tableNumber) == null
                || !this.tableRepository.byNumber(tableNumber).isReservedTable()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.healthFoodRepository.foodByName(healthyFoodName) == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        this.tableRepository.byNumber(tableNumber).orderHealthy(this.healthFoodRepository.foodByName(healthyFoodName));
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        if (this.tableRepository.byNumber(tableNumber) == null
                || !this.tableRepository.byNumber(tableNumber).isReservedTable()) {

            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.beverageRepository.beverageByName(name, brand) == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }
        this.tableRepository.byNumber(tableNumber)
                .orderBeverages(this.beverageRepository.beverageByName(name, brand));
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);

    }

    @Override
    public String closedBill(int tableNumber) {
        double bill = this.tableRepository.byNumber(tableNumber).bill();
        totalBills = totalBills + bill;
        this.tableRepository.byNumber(tableNumber).clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalBills);
    }
}
