package expression;

import java.util.Objects;

public abstract class AbstractBinaryOperation implements CommonOperation{
    private final CommonOperation left, right;
    public AbstractBinaryOperation(CommonOperation left, CommonOperation right) {
        this.left = left;
        this.right = right;
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
    protected abstract int calculate(int x, int y);

    protected abstract double calculate(double x, double y);

    protected abstract int getPriority();

    protected abstract boolean getAssociativity();

    @Override
    public int evaluate(int x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public double evaluate(double x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof AbstractBinaryOperation) {
            AbstractBinaryOperation k = (AbstractBinaryOperation) obj;
            return     k.getOperator().equals(getOperator())
                    && k.getLeft().equals(left)
                    && k.getRight().equals(right);
        } else {
            return false;
        }
    }

    private CommonOperation getLeft() {
        return left;
    }

    private CommonOperation getRight() {
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
