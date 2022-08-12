package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {
    @Override
    public TripleExpression parse(String source) {
        return parse(new StringSource(source));
    }

    public static TripleExpression parse(CharSource source) {
        return new InternalParser(source).parseExternal();
    }

    private static class InternalParser extends BaseParser {
        CommonOperation result;
        public InternalParser(final CharSource source) {
            super(source);
            nextChar();
        }

        public CommonOperation parseExternal() {
            result = parseOr();
            return result;
        }

        private CommonOperation parseOr() {
            result = parseXor();
            while (true) {
                if (test('|')) {
                    result = new Or(result, parseXor());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseXor() {
            result = parseAnd();
            while (true) {
                if (test('^')) {
                    result = new Xor(result, parseAnd());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseAnd() {
            result = parseAddSubtract();
            while (true) {
                if (test('&')) {
                    result = new And(result, parseAddSubtract());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseAddSubtract() {
            result = parseMultiplyDivide();
            while (true) {
                if (test('+')) {
                    result = new Add(result, parseMultiplyDivide());
                } else if (test('-')){
                    result = new Subtract(result, parseMultiplyDivide());
                } else {
                    return result;
                }
            }
        }

        private CommonOperation parseMultiplyDivide() {
            result = ParseElem();
            while (true) {
                skipWhitespace();
                if (test('*')) {
                    result = new Multiply(result, ParseElem());
                } else if (test('/')){
                    result = new Divide(result, ParseElem());
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
                result = parseOr();
                test(')');
                return result;
            } else if (between('0', '9')) {
                return parseNumber("");
            }  else {
                String text = getString();
                switch (text) {
                    case ("flip") :
                        return new Flip(ParseElem());
                    case ("low") :
                        return new Low(ParseElem());
                    default:
                        return parseVariable(text);
                }
            }
        }

        private CommonOperation parseVariable(String text) {
            return new Variable(text);
        }

        private CommonOperation parseNumber(String s) {
            final StringBuilder sb = new StringBuilder(s);
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
            return new Const(Integer.parseInt(sb.toString()));
        }

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t'));
        }
    }
}
