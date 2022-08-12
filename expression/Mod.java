package expression;

import expression.generic.GenericTabulator;
import expression.generic.TypeGeneric;

public class Mod<T> extends AbstractBinaryOperation<T> {
    public Mod (CommonOperation<T> left, CommonOperation<T> right, TypeGeneric<T> t) {
        super(left, right, t);
    }

    @Override
    protected String getOperator() {
        return ("mod");
    }

    protected T calculate(T x, T y) {
        return t.mod(x, y);
    }

    @Override
    protected int getPriority() {
        return -10;
    }

    @Override
    protected boolean getAssociativity() {
        return false;
    }
}
