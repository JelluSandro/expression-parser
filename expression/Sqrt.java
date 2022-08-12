package expression;

import java.util.InputMismatchException;

public class Sqrt extends AbstractUnaryOperation {
    public Sqrt(CommonOperation right) {
        super(right);
    }

    @Override
    protected String getOperator() {
        return "sqrt";
    }

    @Override
    protected int calculate(int x) {
        if (x < 0) {
            throw new InputMismatchException();
        }
        return (int)Math.sqrt(x);
    }
}