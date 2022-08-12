package expression.exceptions;

public class OverflowException extends RuntimeException {
    public OverflowException(String where, String what) {
        super(where + " overflowed by " + what);
    }
}