package expression;

public class Multiply extends AbstractBinaryOperation {
    public Multiply(CommonOperation left, CommonOperation right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return ("*");
    }

    @Override
    protected int calculate(int x, int y) {
        return x * y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x * y;
    }

    protected int getPriority() {
        return 1;
    }

    @Override
    protected boolean getAssociativity() {
        return false;
    }
}
