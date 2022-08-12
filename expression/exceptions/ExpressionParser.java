package expression.exceptions;

import expression.*;
import expression.parser.CharSource;
import expression.parser.StringSource;

public class ExpressionParser implements Parser {
    @Override
    public TripleExpression parse(String source) {
        return parse(new StringSource(source));
    }

    public static TripleExpression parse(CharSource source) {
        return new InternalParser(source).parseExternal();
    }

    private static class InternalParser extends BaseParser {
        CommonOperation VariableX = new Variable("x");
        CommonOperation VariableY = new Variable("y");
        CommonOperation VariableZ = new Variable("z");
        public InternalParser(final CharSource source) {
            super(source);
            nextChar();
        }

        public CommonOperation parseExternal() {
            CommonOperation result = parseGcdLcm();
            if (eof()) {
                return result;
            } else {
                throw new ExpressionException("End of expression expected. in " + t);
            }
        }

        private CommonOperation parseGcdLcm() {
            CommonOperation result = parseAddSubtract();
            while (true) {
                if (test('l')) {
                    expect("cm");
                    if (Character.isLetter(ch) || Character.isDigit(ch)) {
                        throw new ExpressionException("unknown variable found 'lcm" + ch + "' in " + t);
                    }
                    result = new Lcm(result, parseAddSubtract());
                } else if (test('g')) {
                    expect("cd");
                    if (Character.isLetter(ch) || Character.isDigit(ch)) {
                        throw new ExpressionException("unknown variable found 'gcd" + ch + "' in " + t);
                    }
                    result = new Gcd(result, parseAddSubtract());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseAddSubtract() {
            CommonOperation result = parseMultiplyDivide();
            while (true) {
                if (test('+')) {
                    result = new CheckedAdd(result, parseMultiplyDivide());
                } else if (test('-')){
                    result = new CheckedSubtract(result, parseMultiplyDivide());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseMultiplyDivide() {
            CommonOperation result = ParseElem();
            while (true) {
                skipWhitespace();
                if (test('*')) {
                    result = new CheckedMultiply(result, ParseElem());
                } else if (test('/')){
                    result = new CheckedDivide(result, ParseElem());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation ParseElem() {
            skipWhitespace();
            if (test('-')) {
                if (between('0', '9')) {
                    return parseNumber("-");
                }
                return new UnaryMinus(ParseElem());
            } else if (test('(')) {
                CommonOperation result = parseGcdLcm();
                if (!test(')')) {
                    throw new ExpressionException("expected closed bracket ')', found '" + ch + "' in " + t);
                }
                return result;
            } else if (between('0', '9')) {
                return parseNumber("");
            }  else {
                String text = getString();
                switch (text) {
                    case ("abs") :
                        return new Abs(ParseElem());
                    case ("sqrt") :
                        return new Sqrt(ParseElem());
                    default:
                        return parseVariable(text);
                }
            }
        }

        private CommonOperation parseVariable(String text) {
            if (text.equals("x")) {
                return VariableX;
            }
            if (text.equals("y")) {
                return VariableY;
            }
            if (text.equals("z")) {
                return VariableZ;
            }
            throw new ExpressionException("unknown variable " + text + " in " + t);
        }

        private CommonOperation parseNumber(String s) {
            final StringBuilder sb = new StringBuilder(s);
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
            try {
                return new Const(Integer.parseInt(sb.toString()));
            } catch (NumberFormatException e) {
                throw new ExpressionException("Invalid number " + sb + " in " + t);
            }
        }

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t'));
        }
    }
}
