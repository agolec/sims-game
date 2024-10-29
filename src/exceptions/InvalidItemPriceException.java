package exceptions;

/**
 * InvalidItemPriceException is thrown when the price of an item is less than 0.
 */
public class InvalidItemPriceException extends Exception {
    public InvalidItemPriceException(String message){
        super(message);

    }
}
