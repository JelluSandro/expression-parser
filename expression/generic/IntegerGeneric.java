package expression.generic;


public class IntegerGeneric extends UIntegerGeneric implements TypeGeneric<Integer> {

    @Override
    public Integer add(Integer x, Integer y) {
        if (y > 0 && Integer.MAX_VALUE - y < x) {
            throw new CalculationException("IntegerException","overflow add");
        } else if (y < 0 && Integer.MIN_VALUE - y > x) {
            throw new CalculationException("IntegerException","overflow add");
        }
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        if (y > 0 && Integer.MIN_VALUE + y > x) {
            throw new CalculationException("IntegerException","overflow substr");
        } else if (y < 0 && Integer.MAX_VALUE + y < x) {
            throw new CalculationException("IntegerException","overflow substr");
        }
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        if (x != 0 && y != 0) {
            if (x == -1 && y == Integer.MIN_VALUE || y == -1 && x == Integer.MIN_VALUE) {
                throw new CalculationException("IntegerException","overflow mul");
            } else if (x * y == Integer.MIN_VALUE && Integer.MIN_VALUE / y == x) {
                //skip
            } else if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
                throw new CalculationException("IntegerException","overflow mul");
            } else if (Integer.MAX_VALUE / abs(x) < abs(y)) {
                throw new CalculationException("IntegerException","overflow mul");
            }
        }
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (y == 0) {
            throw new CalculationException("IntegerException","divide by zero");
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new CalculationException("IntegerException","Overflow in divide");
        }
        return x / y;
    }

    @Override
    public Integer negate(Integer x) {
        if (x == Integer.MIN_VALUE) {
            throw new CalculationException("IntegerException","Overflow in negate");
        }
        return -x;
    }

    @Override
    public Integer abs(Integer x) {
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                throw new CalculationException("IntegerException","Overflow in abs");
            }
            x *= -1;
        }
        return x;
    }

    @Override
    public Integer square(Integer x) {
        return multiply(x, x);
    }
}
