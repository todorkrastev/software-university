package bg.softuni.java_oop.inheritance.exercises.P06_Animals;

public class Validator {

    public static void validateStringInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public Validator() {
    }
}
