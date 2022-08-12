package expression;

public class Add extends AbstractBinaryOperation {
    public Add (CommonOperation left, CommonOperation right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return ("+");
    }

    @Override
    protected int calculate(int x, int y) {
        return x + y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x + y;
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
