package expression;

public interface CommonOperation<T> extends TripleExpression<T> {
    String toString();
    boolean equals(Object x);
    int hashCode();
    String toMiniString(boolean internalFlag, boolean associativity, int priority);
}
