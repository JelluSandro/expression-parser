package expression.generic;

import java.math.BigInteger;

public class BigIntegerGeneric implements TypeGeneric<BigInteger> {

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO)) {
            throw new CalculationException("BigInteger","divide by zero");
        }
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger x) {
        return x.negate();
    }

    @Override
    public BigInteger cnt(String s) {
        return new BigInteger(s);
    }

    @Override
    public BigInteger value(BigInteger x) {
        return x;
    }

    @Override
    public BigInteger create(int x) {
        return BigInteger.valueOf(x);
    }

    @Override
    public BigInteger abs(BigInteger x) {
        return x.abs();
    }

    @Override
    public BigInteger square(BigInteger x) {
        return x.multiply(x);
    }

    @Override
    public BigInteger mod(BigInteger x, BigInteger y) {
        if (y.compareTo(BigInteger.ZERO) <= 0) {
            throw new CalculationException("BigInteger","mod, second argument less zero");
        }
        return x.mod(y);
    }
}
