package expression;

public class Flip extends AbstractUnaryOperation {
    public Flip(CommonOperation right) {
        super(right);
    }

    @Override
    protected String getOperator() {
        return ("flip");
    }

    @Override
    protected int calculate(int x) {
        int result = 0;
        while(x != 0) {
            result <<= 1;
            result += x & 1;
            x >>>= 1;
        }
        return result;
    }
}