package expression;

public interface CommonOperation extends Expression, TripleExpression, DoubleExpression {
    String toString();
    boolean equals(Object x);
    int hashCode();
    String toMiniString(boolean internalFlag, boolean associativity, int priority);
}
