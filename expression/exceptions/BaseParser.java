package expression.exceptions;

import expression.parser.CharSource;

public class BaseParser {
    public static final char END = '\0';
    private final CharSource source;
    protected char ch = 0xffff;
    int t = 0;

    protected BaseParser(final CharSource source) {
        this.source = source;
    }

    protected void nextChar() {
        t++;
        ch = source.hasNext() ? source.next() : END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected String getString() {
        StringBuilder sb = new StringBuilder();
        while(Character.isLetter(ch) || Character.isDigit(ch)){
            sb.append(ch);
            nextChar();
        }
        return sb.toString();
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw new ExpressionException("Expected '" + c + "', found '" + ch + "' in" + t);
        }
        nextChar();
    }

    protected void expect(final String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean eof() {
        return test(END);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}