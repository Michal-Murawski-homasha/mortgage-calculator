package model.exception;

public class InstalmentCalculationException extends RuntimeException {
    public InstalmentCalculationException() {
        super("Case not handled");
    }

    public InstalmentCalculationException(String message) {
        super(message);
    }
}
