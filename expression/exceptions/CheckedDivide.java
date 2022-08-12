package expression.exceptions;

import expression.CommonOperation;
import expression.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide (CommonOperation left, CommonOperation right) {
        super(left, right);
    }
    @Override
    protected int calculate(int x, int y) {
        if (y == 0) {
            throw new DivByZeroException();
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new DivOverflowException(x, y);
        }
        return x / y;
    }
}
