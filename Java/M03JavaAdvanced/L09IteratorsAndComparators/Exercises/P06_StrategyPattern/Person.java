package bg.softuni.java_advanced.iterators_and_comparators.exercises.P06_StrategyPattern;

public class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("You can not create person whit negative age!");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", getName(), getAge());
    }
}
