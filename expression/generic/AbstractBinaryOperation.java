package expression.generic;

import java.util.Objects;

public abstract class AbstractBinaryOperation<T> implements CommonOperation<T> {
    private final CommonOperation<T> left, right;
    protected final TypeGeneric<T> t;
    public AbstractBinaryOperation(CommonOperation<T> left, CommonOperation<T> right, TypeGeneric<T> t) {
        this.left = left;
        this.right = right;
        this.t = t;
    }

    protected abstract String getOperator();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(left.toString()).append(getOperatorWhite()).append(right.toString()).append(")");
        return (sb.toString());
    }

    private String getOperatorWhite() {
        return " " + getOperator() + " ";
    }

    protected abstract T calculate(T x, T y);

    protected abstract int getPriority();

    protected abstract boolean getAssociativity();

    @Override
    public T evaluate(T x, T y, T z) {
        return calculate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof AbstractBinaryOperation) {
            AbstractBinaryOperation<T> k = (AbstractBinaryOperation<T>) obj;
            return     k.getOperator().equals(getOperator())
                    && k.getLeft().equals(left)
                    && k.getRight().equals(right);
        } else {
            return false;
        }
    }

    private CommonOperation<T> getLeft() {
        return left;
    }

    private CommonOperation<T> getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperator(), right, left);
    }

    private void addToMiniString(StringBuilder sb) {
        sb.append(left.toMiniString(true, getAssociativity(), getPriority()));
        sb.append(getOperatorWhite());
        sb.append(right.toMiniString(false, getAssociativity(), getPriority()));
    }

    private boolean check(int priorityInternal, int priorityExternal, boolean internalFlag, boolean associativity) {
        return priorityInternal > priorityExternal
                || (priorityExternal == priorityInternal
                && !internalFlag && (associativity || getAssociativity()));
    }

    @Override
    public String toMiniString(boolean internalFlag, boolean associativity, int priorityExternal) {
        StringBuilder t = new StringBuilder();
        final int priorityInternal = this.getPriority();
        boolean flag = check(priorityInternal, priorityExternal, internalFlag, associativity);
        if (flag) {
            t.append("(");
        }
        addToMiniString(t);
        if (flag) {
            t.append(")");
        }
        return (t.toString());
    }

    @Override
    public String toMiniString() {
        StringBuilder t = new StringBuilder();
        addToMiniString(t);
        return (t.toString());
    }
}
