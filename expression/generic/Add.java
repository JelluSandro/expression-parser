package expression.generic;

public class Add<T> extends AbstractBinaryOperation<T> {
    public Add (CommonOperation<T> left, CommonOperation<T> right, TypeGeneric<T> t) {
        super(left, right, t);
    }

    @Override
    protected String getOperator() {
        return ("+");
    }

    protected T calculate(T x, T y) {
        return t.add(x, y);
    }

    @Override
    protected int getPriority() {
        return 2;
    }

    @Override
    protected boolean getAssociativity() {
        return false;
    }
}
