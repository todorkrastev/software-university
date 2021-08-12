package exception;

public class NotEnoughMemory extends RuntimeException{

    public NotEnoughMemory(String message){
        super(message);
    }
}
