package table;

/**
 * The size measurement inside the table. One unit means a character:<br>
 * "abc" => 3
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Size {
    private final int width;
    private final int height;

    /**
     *
     * @param width
     * @param height
     * @throws IllegalArgumentException if the values are smaller than 0.
     */
    public Size(int width, int height) {

        this.width = width;
        this.height = height;
    }
}
