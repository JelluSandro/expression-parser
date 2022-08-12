package expression.exceptions;

import expression.Add;
import expression.CommonOperation;

public class CheckedAdd extends Add {
    public CheckedAdd (CommonOperation left, CommonOperation right) {
        super(left, right);
    }
    @Override
    protected int calculate(int x, int y) {
        if (y > 0 && Integer.MAX_VALUE - y < x) {
            throw new AddOverflowException(x, y);
        } else if (y < 0 && Integer.MIN_VALUE - y > x) {
            throw new AddOverflowException(x, y);
        }
        return x + y;
    }
}
