package expression.generic;

import java.util.InputMismatchException;

import static java.lang.StrictMath.abs;

public class PIntegerGeneric extends UIntegerGeneric implements TypeGeneric<Integer> {
    int md = 1009;
    int[] p = new int[md];

    public PIntegerGeneric() {
        p[0] = 0;
        p[1] = 1;
        for (int i = 2; i < md; ++i) {
            p[i] = (md - (md / i) * p[md % i] % md) % md;
        }
    }

    private Integer md(Integer x) {
        int ans = x;

        if (ans < 0) {
            return md + (ans % 1009);
        }
        return ans % 1009;
    }

    @Override
    public Integer add(Integer x, Integer y) {
        return md(x + y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return md(x - y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return md(x * y);
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (y == 0) {
            throw new CalculationException("P mode","divide by zero");
        }
        return md(x * p[y]);
    }

    @Override
    public Integer negate(Integer x) {
        return md(-x);
    }

    @Override
    public Integer value(Integer x) {
        return md(x);
    }

    @Override
    public Integer cnt(String s) {
        return md(Integer.parseInt(s));
    }

    @Override
    public Integer create(int x) {
        return md(x);
    }

    @Override
    public Integer abs(Integer x) {
        return md(super.abs(x));
    }

    @Override
    public Integer square(Integer x) {
        return md(x * x);
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        return md(super.mod(x, y));
    }
}
