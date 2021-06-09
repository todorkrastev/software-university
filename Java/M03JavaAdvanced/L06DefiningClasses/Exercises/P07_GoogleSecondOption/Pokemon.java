package bg.softuni.java_advanced.defining_classes.exercises.P07_GoogleSecondOption;

public class Pokemon {
    private final String name;
    private final String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String format() {
        return String.format("%s %s", name, type);
    }
}
