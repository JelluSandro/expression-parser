package expression.generic;

public class Variable<T> implements CommonOperation<T> {
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
    public T evaluate(T x, T y, T z) {
        if (var.equals("x")) {
            return x;
        } else if (var.equals("y")) {
            return y;
        }
        return z;
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
