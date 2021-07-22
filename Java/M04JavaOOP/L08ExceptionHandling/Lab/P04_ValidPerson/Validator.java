package bg.softuni.java_oop.exception_handling.P04_ValidPerson;

public class Validator {
    public Validator() {
    }

    protected static void validateName(String input, String type) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("The " + type + " name cannot be null or empty string.");
        }
    }

    protected static void validateAge(int age) {
        if (age < 0 || 120 < age) {
            throw new IllegalArgumentException("Invalid age: " + age + ". Age should be in the range 0 <= age <= 120");
        }
    }
}
