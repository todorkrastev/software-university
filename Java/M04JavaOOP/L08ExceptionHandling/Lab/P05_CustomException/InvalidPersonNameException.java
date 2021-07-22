package bg.softuni.java_oop.exception_handling.P05_CustomException;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String massage) {
        super(massage);
    }
}

