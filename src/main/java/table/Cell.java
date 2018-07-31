package table;

import table.output.Media;

import java.util.Objects;

/**
 * A cell inside the table.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Cell {
    private final Border border;

    public Cell(Border border) {
        this.border = Objects.requireNonNull(border);
    }

    public void printTo(Media media) {
        media.print(
                String.join(
                        border.left(),
                        border.right()
                )
        );
    }
}
