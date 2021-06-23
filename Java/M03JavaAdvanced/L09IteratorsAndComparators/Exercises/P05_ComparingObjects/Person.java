package bg.softuni.java_advanced.iterators_and_comparators.exercises.P05_ComparingObjects;

public class Person implements Comparable<Person> {

    private final String name;
    private final String town;
    private int age;

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
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

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.getName());
        if (result == 0) {
            result = Integer.compare(this.age, o.getAge());
        }
        if (result == 0) {
            result = this.town.compareTo(o.getTown());
        }
        return result;
    }
}