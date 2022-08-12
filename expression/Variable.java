package expression;

public class Variable implements CommonOperation {
    private String var;

    public Variable(String var) {
        this.var = var;
    }

    public String toString() {
        return var;
    }

    @Override
    public String toMiniString() {
        return var;
    }

    @Override
    public String toMiniString(boolean internalFlag, boolean associativity, int priority) {
        return var;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (var.equals("x")) {
            return x;
        } else if (var.equals("y")) {
            return y;
        } else if (var.equals("z")) {
            return z;
        }
        return 0;
    }

    @Override
    public boolean equals(Object x) {
        return (x instanceof Variable && var.equals(((Variable) x).getString()));
    }

    private String getString() {
        return var;
    }

    @Override
    public int hashCode() {
        return var.hashCode();
    }
}
