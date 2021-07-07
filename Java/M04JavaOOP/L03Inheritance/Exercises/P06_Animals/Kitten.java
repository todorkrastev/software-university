package bg.softuni.java_oop.inheritance.exercises.P06_Animals;

public class Kitten extends Cat {

    protected static final String KITTEN_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
