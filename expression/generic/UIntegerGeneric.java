package expression.generic;

import java.util.InputMismatchException;

import static java.lang.StrictMath.abs;

public class UIntegerGeneric implements TypeGeneric<Integer>{

    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (y == 0) {
            throw new CalculationException("U mode","divide by zero");
        }
        return x / y;
    }

    @Override
    public Integer negate(Integer x) {
        return -x;
    }

    @Override
    public Integer value(Integer x) {
        return x;
    }

    @Override
    public Integer cnt(String s) {
        return Integer.parseInt(s);
    }

    @Override
    public Integer create(int x) {
        return x;
    }

    @Override
    public Integer abs(Integer x) {
        if (x < 0) {
            x *= -1;
        }
        return x;
    }

    @Override
    public Integer square(Integer x) {
        return multiply(x, x);
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        if (y == 0) {
            throw new CalculationException("u mode","mod by zero");
        }
        return x % y;
    }
}
