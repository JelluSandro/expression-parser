package expression.generic;


public class ByteGeneric implements TypeGeneric<Byte>{

    @Override
    public Byte add(Byte x, Byte y) {
        return (byte)(x + y);
    }

    @Override
    public Byte subtract(Byte x, Byte y) {
        return (byte)(x - y);
    }

    @Override
    public Byte multiply(Byte x, Byte y) {
        return (byte)(x * y);
    }

    @Override
    public Byte divide(Byte x, Byte y) {
        if (y == 0) {
            throw new CalculationException("Byte","divide by zero");
        }
        return (byte)(x / y);
    }

    @Override
    public Byte negate(Byte x) {
        return (byte)(-x);
    }

    @Override
    public Byte value(Byte x) {
        return (byte)(x);
    }

    @Override
    public Byte cnt(String s) {
        return Byte.parseByte(s);
    }

    @Override
    public Byte create(int x) {
        return (byte)(x);
    }

    @Override
    public Byte abs(Byte x) {
        if (x < 0) {
            x = (byte)(-1 * x);
        }
        return (byte)(x);
    }

    @Override
    public Byte square(Byte x) {
        return multiply(x, x);
    }

    @Override
    public Byte mod(Byte x, Byte y) {
        if (y == 0) {
            throw new CalculationException("Byte","mod second argument less zero");
        }
        return (byte)(x % y);
    }
}
