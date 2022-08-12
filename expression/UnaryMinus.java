package expression;

import expression.generic.TypeGeneric;

public class UnaryMinus<T> extends AbstractUnaryOperation<T> {
    public UnaryMinus(CommonOperation<T> right, TypeGeneric<T> t) {
        super(right, t);
    }

    @Override
    protected String getOperator() {
        return ("-");
    }

    @Override
    protected T calculate(T x) {
        return t.negate(x);
    }
}