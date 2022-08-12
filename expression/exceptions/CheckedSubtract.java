package expression.exceptions;

import expression.CommonOperation;
import expression.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract (CommonOperation left, CommonOperation right) {
        super(left, right);
    }
    @Override
    protected int calculate(int x, int y) {
        if (y > 0 && Integer.MIN_VALUE + y > x) {
            throw new SubtractOverflowException(x, y);
        } else if (y < 0 && Integer.MAX_VALUE + y < x) {
            throw new SubtractOverflowException(x, y);
        }
        return x - y;
    }
}
