package bg.manhattan.coffeeshop.model.enums;

public enum CategoryName {
    COFFEE, CAKE, DRINK, OTHER;

    public Integer getCategoryTime() {
        return switch (this) {
            case CAKE -> 10;
            case DRINK -> 1;
            case COFFEE -> 2;
            case OTHER -> 5;
        };
    }
}
