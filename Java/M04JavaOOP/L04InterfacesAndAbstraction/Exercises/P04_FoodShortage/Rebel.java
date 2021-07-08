package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P04_FoodShortage;

public class Rebel implements Person, Buyer {

    private static final int INCREASE_FOOD_WITH_FIVE = 5;

    private final String name;
    private final int age;
    private final String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += INCREASE_FOOD_WITH_FIVE;
    }

}
