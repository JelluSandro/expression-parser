package expression;

import java.util.InputMismatchException;

public abstract class AbstractTripleOperation extends AbstractBinaryOperation{
    public AbstractTripleOperation(CommonOperation left, CommonOperation right) {
        super(left, right);
    }
    @Override
    protected double calculate(double x, double y) {
        throw new InputMismatchException();
    }
    @Override
    protected boolean getAssociativity() {
        return true;
    }
}
