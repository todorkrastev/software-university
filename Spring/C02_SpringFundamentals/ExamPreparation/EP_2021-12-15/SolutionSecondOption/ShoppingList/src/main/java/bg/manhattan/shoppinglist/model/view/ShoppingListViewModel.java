package bg.manhattan.shoppinglist.model.view;

import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingListViewModel {
    private final List<ShoppingItemViewModel> foods;
    private final List<ShoppingItemViewModel> drinks;
    private final List<ShoppingItemViewModel> households;
    private final List<ShoppingItemViewModel> others;

    private final BigDecimal totalPrice;

    public ShoppingListViewModel(List<ShoppingItemViewModel> shoppingItems) {
        this.foods = getList(shoppingItems, CategoryNameEnum.FOOD);
        this.drinks = getList(shoppingItems, CategoryNameEnum.DRINK);
        this.households = getList(shoppingItems, CategoryNameEnum.HOUSEHOLD);
        this.others = getList(shoppingItems, CategoryNameEnum.OTHER);
        this.totalPrice = shoppingItems
                .stream()
                .map(ShoppingItemViewModel::getPrice)
                .reduce((sum, price) -> sum.add(price))
                .orElse(null);
    }

    public List<ShoppingItemViewModel> getFoods() {
        return foods;
    }

    public List<ShoppingItemViewModel> getDrinks() {
        return drinks;
    }

    public List<ShoppingItemViewModel> getHouseholds() {
        return households;
    }

    public List<ShoppingItemViewModel> getOthers() {
        return others;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    private List<ShoppingItemViewModel> getList(List<ShoppingItemViewModel> shoppingItems, CategoryNameEnum category) {
        return shoppingItems.stream()
                .filter(i -> i.getCategoryName().equals(category))
                .collect(Collectors.toList());
    }
}
