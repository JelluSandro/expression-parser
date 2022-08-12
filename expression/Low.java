package expression;

public class Low extends AbstractUnaryOperation {
    public Low(CommonOperation right) {
        super(right);
    }

    @Override
    protected String getOperator() {
        return "low";
    }

    @Override
    protected int calculate(int x) {
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != 0) {
                return (1 << i);
            }
        }
        return 0;
    }
}