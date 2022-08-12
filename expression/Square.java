package expression;

import expression.generic.TypeGeneric;

import java.util.InputMismatchException;

public class Square<T> extends AbstractUnaryOperation<T> {
    public Square(CommonOperation<T> right, TypeGeneric<T> t) {
        super(right, t);
    }

    @Override
    protected String getOperator() {
        return "square";
    }

    @Override
    protected T calculate(T x) {
        return t.square(x);
    }
}