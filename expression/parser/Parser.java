package expression.parser;

import expression.TripleExpression;
import expression.generic.TypeGeneric;

public interface Parser<T> {
    TripleExpression<T> parse(String expression, TypeGeneric<T> t);
}