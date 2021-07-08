package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P04_FoodShortage;

public class Citizen implements Person, Identifiable, Buyer, Birhtable {

    private static final int INCREASE_FOOD_WITH_TEN = 10;

    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
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

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += INCREASE_FOOD_WITH_TEN;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
