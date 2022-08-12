package expression;

public class Gcd extends AbstractTripleOperation {
    public Gcd (CommonOperation left, CommonOperation right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "gcd";
    }
    private static int abs(int a) {
        return a > 0 ? a : -a;
    }
    @Override
    protected int calculate(int x, int y) {
        x = abs(x);
        y = abs(y);
        while (y != 0) {
            x = x % y;
            int t = x;
            x = y;
            y = t;
        }
        return x;
    }

    protected int getPriority() {
        return 7;
    }
}
