package expression.parser;

import expression.*;
import expression.generic.TypeGeneric;

public class ExpressionParser<T> implements Parser<T> {
    @Override
    public TripleExpression<T> parse(String source, TypeGeneric<T> t) {
        return parse(new StringSource(source), t);
    }

    public TripleExpression<T> parse(CharSource source, TypeGeneric<T> t) {
        return new InternalParser<T>(source, t).parseExternal();
    }

    private static class InternalParser<T> extends BaseParser {
        CommonOperation<T> result;
        TypeGeneric<T> t;

        public InternalParser(final CharSource source, TypeGeneric<T> t) {
            super(source);
            nextChar();
            this.t = t;
        }

        public CommonOperation<T> parseExternal() {
            result = parseAddSubtract();
            return result;
        }

        private CommonOperation<T> parseAddSubtract() {
            result = parseMultiplyDivide();
            while (true) {
                if (test('+')) {
                    result = new Add<T>(result, parseMultiplyDivide(), t);
                } else if (test('-')) {
                    result = new Subtract<T>(result, parseMultiplyDivide(), t);
                } else {
                    return result;
                }
            }
        }

        private CommonOperation<T> parseMultiplyDivide() {
            result = parseMod();
            while (true) {
                skipWhitespace();
                if (test('*')) {
                    result = new Multiply<T>(result, ParseElem(), t);
                } else if (test('/')) {
                    result = new Divide<T>(result, ParseElem(), t);
                } else {
                    return result;
                }
            }
        }

        private CommonOperation<T> parseMod() {
            result = ParseElem();
            while (true) {
                skipWhitespace();
                if (test('m')) {
                    expect("od");
                    result = new Mod<T>(result, ParseElem(), t);
                } else {
                    return result;
                }
            }
        }

        private CommonOperation<T> ParseElem() {
            skipWhitespace();
            if (test('-')) {
                if (between('0', '9')) {
                    return parseNumber("-");
                }
                return new UnaryMinus<T>(ParseElem(), t);
            } else if (test('(')) {
                result = parseAddSubtract();
                test(')');
                return result;
            } else if (between('0', '9')) {
                return parseNumber("");
            } else {
                String text = getString();
                switch (text) {
                    case ("abs"):
                        return new Abs<T>(ParseElem(), t);
                    case ("square"):
                        return new Square<T>(ParseElem(), t);
                    default:
                        return parseVariable(text);
                }
            }
        }

        private CommonOperation<T> parseVariable(String text) {
            return new Variable<T>(text);
        }

        private CommonOperation<T> parseNumber(String s) {
            final StringBuilder sb = new StringBuilder(s);
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
            return new Const<T>(t.cnt(sb.toString()), t);
        }

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t')) ;
        }
    }
}
