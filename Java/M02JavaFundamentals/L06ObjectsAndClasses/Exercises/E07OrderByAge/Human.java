package E07OrderByAge;

public class Human {
    private String name;
    private String ID;
    private int age;

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.%n", name, ID, age);
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public Human(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;



    }
}
