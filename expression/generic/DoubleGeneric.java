package expression.generic;

import java.math.BigInteger;

public class DoubleGeneric implements TypeGeneric<Double> {
    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double negate(Double x) {
        return -x;
    }

    @Override
    public Double value(Double x) {
        return x;
    }

    @Override
    public Double cnt(String s) {
        return Double.parseDouble(s);
    }

    @Override
    public Double create(int x) {
        return (double)x;
    }

    @Override
    public Double abs(Double x) {
        if (x < 0) {
            x *= -1;
        }
        return x;
    }

    @Override
    public Double square(Double x) {
        return x * x;
    }

    @Override
    public Double mod(Double x, Double y) {
        return x % y;
    }
}
