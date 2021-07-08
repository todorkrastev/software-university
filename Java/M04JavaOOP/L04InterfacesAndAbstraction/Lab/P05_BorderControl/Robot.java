package bg.softuni.java_oop.interfaces_and_abstraction.lab.border;

public class Robot implements Identifiable {
    private final String model;
    private final String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
