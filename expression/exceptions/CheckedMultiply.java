package expression.exceptions;

import expression.CommonOperation;
import expression.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply (CommonOperation left, CommonOperation right) {
        super(left, right);
    }
    @Override
    public int calculate(int x, int y) {
        if (x != 0 && y != 0) {
            if (x == -1 && y == Integer.MIN_VALUE || y == -1 && x == Integer.MIN_VALUE) {
                throw new MultiplyOverflowException(x, y);
            } else if (x * y == Integer.MIN_VALUE && Integer.MIN_VALUE / y == x) {
                 //skip
            } else if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
                throw new MultiplyOverflowException(x, y);
            } else if (Integer.MAX_VALUE / abs(x) < abs(y)) {
                throw new MultiplyOverflowException(x, y);
            }
        }
        return (x * y);
    }

    private static int abs(int x) {
        return x > 0 ? x : -x;
    }
}
