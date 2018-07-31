package table;

/**
 * Defines a natural number. It must lie between 0 and 2^31 - 1.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Nat extends Number {
    private final int value;

    public Nat(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    "The number has to be 0 or greater, but is: " + value
            );
        }
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    /**
     * A Nat can only be equal to another Nat.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nat) {
            return value == ((Nat) obj).intValue();
        }
        return false;
    }

    /**
     * @return The number as a string.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
