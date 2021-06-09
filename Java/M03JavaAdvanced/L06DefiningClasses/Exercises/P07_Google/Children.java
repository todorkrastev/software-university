package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

public class Children {
    private final String childName;
    private final String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return childName + " " + childBirthday;
    }
}
