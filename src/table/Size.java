package table;

/**
 * The size measurement inside the table. One unit means a character:<br>
 * "abc" => 3
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Size {
    private final Nat width;
    private final Nat height;

    public Size(int width, int height) {
        this(
                new Nat(width),
                new Nat(height)
        );
    }

    /**
     * Primary constructor.
     * @throws IllegalArgumentException if the values are smaller than 0.
     */
    public Size(Nat width, Nat height) {
        this.width = width;
        this.height = height;
    }

    public Nat width() {
        return width;
    }

    public Nat height() {
        return height;
    }
}
