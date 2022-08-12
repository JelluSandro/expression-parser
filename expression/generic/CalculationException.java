package expression.generic;

public class CalculationException extends RuntimeException  {
    public CalculationException(String where, String what) {
        super(where + " overflowed by " + what);
    }
}
