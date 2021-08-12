package exception;

public class NonExistentObject extends RuntimeException{

    public NonExistentObject(String message){
        super(message);
    }
}
