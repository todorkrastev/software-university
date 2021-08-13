package exceptions;

public class NonExistantModelException extends Exception {
    public NonExistantModelException(){
        super();
    }

    public NonExistantModelException(String message) {
        super(message);
    }
}
