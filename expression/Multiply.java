package expression;

import expression.generic.TypeGeneric;

public class Multiply<T> extends AbstractBinaryOperation<T> {
    public Multiply(CommonOperation<T> left, CommonOperation<T> right, TypeGeneric<T> t) {
        super(left, right, t);
    }

    @Override
    protected String getOperator() {
        return ("*");
    }

    @Override
    protected T calculate(T x, T y) {
        return t.multiply(x, y);
    }

    protected int getPriority() {
        return 1;
    }

    @Override
    protected boolean getAssociativity() {
        return false;
    }
}
