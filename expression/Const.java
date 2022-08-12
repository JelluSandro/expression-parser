package expression;

import expression.generic.TypeGeneric;

public class Const<T> implements CommonOperation<T> {
    private TypeGeneric<T> t;
    private T con;
    public Const(T con, TypeGeneric<T> t) {
        this.con = con;
        this.t = t;
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

    private T getNumber() {
        return con;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return t.value(con);
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
