package expression;

public class Divide extends AbstractBinaryOperation {
    public Divide(CommonOperation left, CommonOperation right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return ("/");
    }

    @Override
    protected int calculate(int x, int y) {
        return x / y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x / y;
    }

    protected int getPriority() {
        return 1;
    }

    @Override
    protected boolean getAssociativity() {
        return true;
    }
}
