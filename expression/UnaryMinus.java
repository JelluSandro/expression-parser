package expression;

public class UnaryMinus extends AbstractUnaryOperation {
    public UnaryMinus(CommonOperation right) {
        super(right);
    }

    @Override
    protected String getOperator() {
        return ("-");
    }

    @Override
    protected int calculate(int x) {
        return (-x);
    }
}