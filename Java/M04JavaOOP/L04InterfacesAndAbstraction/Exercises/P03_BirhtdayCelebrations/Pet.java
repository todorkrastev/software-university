package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P03_BirhtdayCelebrations;

public class Pet implements Birthable {
    private final String name;
    private final String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
