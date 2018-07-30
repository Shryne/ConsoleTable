package table;

import java.util.Objects;

/**
 * A group of cells.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Cells {
    private final Cell[] cells;

    /**
     * Primary constructor.
     */
    public Cells(Cell... cells) {
        this.cells = Objects.requireNonNull(cells);
    }
}
