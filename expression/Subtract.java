package expression;

import expression.generic.TypeGeneric;

public class Subtract<T> extends AbstractBinaryOperation<T> {
    public Subtract (CommonOperation<T> left, CommonOperation<T> right, TypeGeneric<T> t) {
        super(left, right, t);
    }
    @Override
    protected String getOperator() {
        return ("-");
    }

    @Override
    protected T calculate(T x, T y) {
        return t.subtract(x, y);
    }

    protected int getPriority() {
        return 2;
    }

    @Override
    protected boolean getAssociativity() {
        return true;
    }
}
