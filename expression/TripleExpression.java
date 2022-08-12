package expression;

import expression.generic.TypeGeneric;

public interface TripleExpression<T> extends ToMiniString {
    T evaluate(T x, T y, T z);
}