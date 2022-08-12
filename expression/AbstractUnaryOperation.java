package expression;

import expression.generic.TypeGeneric;

import java.util.InputMismatchException;
import java.util.Objects;

public abstract class AbstractUnaryOperation<T> implements CommonOperation<T>{
    private final CommonOperation<T> right;
    protected TypeGeneric<T> t;
    public AbstractUnaryOperation(CommonOperation<T> right, TypeGeneric<T> t) {
        this.right = right;
        this.t = t;
    }
    protected abstract String getOperator();
    public String toString() {
        StringBuilder t = new StringBuilder("");
        t.append("(").append(getOperator()).append(right.toString()).append(")");
        return (t.toString());
    }
    protected abstract T calculate(T x);
    @Override
    public T evaluate(T x, T y, T z) {
        return calculate(right.evaluate(x, y, z));
    }
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof AbstractUnaryOperation
                && ((AbstractUnaryOperation<T>) obj).getOperator().equals(getOperator())
                && ((AbstractUnaryOperation<T>) obj).getRight().equals(right);
    }
    private CommonOperation<T> getRight() {
        return right;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOperator(), right);
    }
    private StringBuilder MiniString() {
        StringBuilder t = new StringBuilder("");
        t.append(getOperator());
        t.append(right.toMiniString(false, false, Integer.MAX_VALUE));
        return t;
    }
    public String toMiniString() {
        return (MiniString().toString());
    }
    public String toMiniString(boolean x1, boolean x2, int x3) {
        return (MiniString().toString());
    }
}
