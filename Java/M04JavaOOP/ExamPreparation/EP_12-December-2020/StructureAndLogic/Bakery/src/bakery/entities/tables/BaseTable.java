package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {


    private final int tableNumber;
    private int capacity;
    private final double pricePerPerson;

    private boolean isReserved;
    private int numberOfPeople;
    private double price;

    private final Collection<BakedFood> foodOrders;
    private final Collection<Drink> drinkOrders;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.setReserved(false);
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.price = this.getPricePerPerson() * this.getNumberOfPeople();
        this.setReserved(true);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double priceAllDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double priceAllFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        return priceAllDrinks + priceAllFood + this.getPrice();
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.setReserved(false);
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {

        return String.format("Table: %d", this.getTableNumber()) +
                System.lineSeparator() +
                String.format("Type: %s", this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("Capacity: %d", this.getCapacity()) +
                System.lineSeparator() +
                String.format("Price per Person: %.2f",
                        this.getPricePerPerson());
    }
}