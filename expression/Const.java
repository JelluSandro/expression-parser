package expression;

public class Const implements CommonOperation {
    private Number con;
    public Const(Number con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return con.toString();
    }

    @Override
    public String toMiniString() {
        return this.toString();
    }

    @Override
    public String toMiniString(boolean internalFlag, boolean priority, int x) {
        return this.toString();
    }

    @Override
    public int evaluate(int x) {
        return con.intValue();
    }

    @Override
    public double evaluate(double x) {
        return con.doubleValue();
    }

    private Number getNumber() {
        return con;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return con.intValue();
    }

    @Override
    public boolean equals(Object x) {
        return (x instanceof Const && con.equals(((Const) x).getNumber()));
    }

    @Override
    public int hashCode() {
        return con.hashCode();
    }
}
