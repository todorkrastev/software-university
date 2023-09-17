package bg.manhattan.coffeeshop.model.view;

public class UserOrdersViewModel {
    private String username;
    private Integer ordersCount;

    public UserOrdersViewModel(String username, Integer ordersCount) {
        this.username = username;
        this.ordersCount = ordersCount;
    }

    public String getUsername() {
        return username;
    }

    public UserOrdersViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public UserOrdersViewModel setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
        return this;
    }
}
