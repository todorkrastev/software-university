package bg.softuni.java_oop.exception_handling.P05_CustomException;

public class Validator {
    public Validator() {
    }

    protected static void ValidateName(String name) {
        if (!name.matches("^[A-Za-z]+$")) {
            throw new InvalidPersonNameException("Invalid name: " + name + ". The name cannot contain any special character or numeric value." +
                    "Please, enter valid name.");
        }
    }

    protected static void ValidateEmail(String email) {
        if (!email.contains("@")) {
            throw new InvalidPersonNameException("Invalid email: " + email + ". Please, enter valid email address.");
        }
    }
}
