package expression.generic;

import expression.TripleExpression;
import expression.parser.ExpressionParser;

import java.io.IOError;
import java.io.IOException;
import java.math.BigInteger;


public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception{
        switch (mode) {
            case "i":
                return tab(new IntegerGeneric(), expression, x1, x2, y1, y2, z1, z2);
            case "d":
                return tab(new DoubleGeneric(), expression, x1, x2, y1, y2, z1, z2);
            case "u":
                return tab(new UIntegerGeneric(), expression, x1, x2, y1, y2, z1, z2);
            case "p":
                return tab(new PIntegerGeneric(), expression, x1, x2, y1, y2, z1, z2);
            case "bi":
                return tab(new BigIntegerGeneric(), expression, x1, x2, y1, y2, z1, z2);
            case "b":
                return tab(new ByteGeneric(), expression, x1, x2, y1, y2, z1, z2);
        }
        throw new IOException();
    }
    public <T> Object[][][] tab(TypeGeneric<T> t, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception{
        Object[][][] table = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        ExpressionParser<T> parser = new ExpressionParser<>();
        TripleExpression<T> tripleExpression = parser.parse(expression, t);
        System.out.println(tripleExpression.toMiniString());
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        table[i - x1][j - y1][k - z1] = tripleExpression.evaluate(t.create(i), t.create(j), t.create(k));
                    } catch (CalculationException e) {
                        // skip
                    }
                }
            }
        }
        return table;
    }
}
