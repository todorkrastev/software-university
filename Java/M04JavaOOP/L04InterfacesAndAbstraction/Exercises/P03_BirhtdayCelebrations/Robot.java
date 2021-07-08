package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P03_BirhtdayCelebrations;

public class Robot implements Identifiable {
    private final String id;
    private final String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
