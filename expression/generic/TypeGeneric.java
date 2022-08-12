package expression.generic;

public interface TypeGeneric<T> {
    T add(T x, T y);
    T subtract(T x, T y);
    T multiply(T x, T y);
    T divide(T x, T y);
    T negate(T x);
    T value(T x);
    T cnt(String s);
    T create(int x);
    T abs(T x);
    T square(T x);
    T mod (T x, T y);
}
