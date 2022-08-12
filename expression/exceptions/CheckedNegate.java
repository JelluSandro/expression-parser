package expression.exceptions;

import expression.CommonOperation;
import expression.UnaryMinus;

public class CheckedNegate extends UnaryMinus {
    public CheckedNegate (CommonOperation right) {
        super(right);
    }
    @Override
    protected int calculate(int in) {
        if (in == Integer.MIN_VALUE) {
            throw new NegateOverflowException(in);
        }
        return -in;
    }
}
