package davlks.atm.exceptions;

public class NotEnoughMoneyException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Sorry, but this amount of money cannot be withdrawn, try a smaller amount";
    }
}
