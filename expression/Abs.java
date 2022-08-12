package expression;

import expression.exceptions.OverflowException;

import java.util.InputMismatchException;

public class Abs extends AbstractUnaryOperation {
    public Abs(CommonOperation right) {
        super(right);
    }

    @Override
    protected String getOperator() {
        return "abs";
    }

    @Override
    protected int calculate(int x) {
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                throw new InputMismatchException();
            }
            x *= -1;
        }
        return x;
    }
}