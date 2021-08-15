package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private int number;
    private int size;
    private double pricePerPerson;

    private boolean isReservedTable;
    private int numberOfPeople;
    private double allPeople;


    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.setReservedTable(false);
        this.setHealthyFood();
        this.setBeverages();
    }

    private void setHealthyFood() {
        this.healthyFood = new ArrayList<>();
    }

    private void setBeverages() {
        this.beverages = new ArrayList<>();
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setReservedTable(boolean reservedTable) {
        isReservedTable = reservedTable;
    }

    private void setAllPeople(double allPeople) {
        this.allPeople = allPeople;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public double getAllPeople() {
        return this.allPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.setAllPeople(this.getPricePerPerson() * this.getNumberOfPeople());
        this.setReservedTable(true);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double priceAllDrinks = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        double priceAllFood = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        return priceAllDrinks + priceAllFood + this.getAllPeople();
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.setReservedTable(false);
        this.setNumberOfPeople(0);
        this.setPricePerPerson(0);
    }

    @Override
    public String tableInformation() {
        return String.format("Table: %d", this.getTableNumber()) +
                System.lineSeparator() +
                String.format("Size: %s", this.getSize()) +
                System.lineSeparator() +
                String.format("Type: %s", this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("Price per Person: %.2f",
                        this.getPricePerPerson());
    }
}
