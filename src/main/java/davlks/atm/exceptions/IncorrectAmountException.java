package davlks.atm.exceptions;

public class IncorrectAmountException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Amount should be divisible by 100";
    }
}
