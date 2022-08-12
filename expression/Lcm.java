package expression;

import expression.exceptions.CheckedMultiply;

public class Lcm extends AbstractTripleOperation {
    public Lcm (CommonOperation left, CommonOperation right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "lcm";
    }

    @Override
    protected int calculate(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        int gcd = new Gcd(new Const(x), new Const(y)).evaluate(0, 0, 0);
        return new CheckedMultiply((new Const(x / gcd )), new Const(y)).evaluate(0, 0, 0);
    }

    protected int getPriority() {
        return 7;
    }
}
