package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

public class Parents {
    private final String parentName;
    private final String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return parentName + " " + parentBirthday;
    }
}
