package exception;

public class NotEnoughCapacity extends RuntimeException{

    public NotEnoughCapacity(String message){
        super(message);
    }
}
