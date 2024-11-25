package exceptions;

public class InvalidItemQuantityException extends Exception {
    public InvalidItemQuantityException(String message){
        super(message);
    }
}
