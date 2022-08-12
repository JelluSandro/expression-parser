package expression.parser;

public class BaseParser {
    public static final char END = '\0';
    private final CharSource source;
    protected char ch = 0xffff;

    protected BaseParser(final CharSource source) {
        this.source = source;
    }

    protected void nextChar() {
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

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}