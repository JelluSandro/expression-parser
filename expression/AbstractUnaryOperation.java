package expression;

import java.util.InputMismatchException;
import java.util.Objects;

public abstract class AbstractUnaryOperation implements CommonOperation{
    private final CommonOperation right;
    public AbstractUnaryOperation(CommonOperation right) {
        this.right = right;
    }
    protected abstract String getOperator();
    public String toString() {
        StringBuilder t = new StringBuilder("");
        t.append("(").append(getOperator()).append(right.toString()).append(")");
        return (t.toString());
    }
    protected abstract int calculate(int x);
    @Override
    public int evaluate(int x) {
        return calculate(right.evaluate(x));
    }
    @Override
    public double evaluate(double x) {
        throw new InputMismatchException();
    }
    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(right.evaluate(x, y, z));
    }
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof AbstractUnaryOperation
                && ((AbstractUnaryOperation) obj).getOperator().equals(getOperator())
                && ((AbstractUnaryOperation) obj).getRight().equals(right);
    }
    private CommonOperation getRight() {
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
