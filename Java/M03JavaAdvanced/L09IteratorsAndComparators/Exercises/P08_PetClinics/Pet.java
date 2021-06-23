package bg.softuni.java_advanced.iterators_and_comparators.exercises.P08_PetClinics;

public class Pet {
    private final String name;
    private final int age;
    private final String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }
}
