package table;

import table.output.Media;

import java.util.Objects;

/**
 * A cell inside the table.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Cell {
    private final Text text;
    private final Size size;
    private final Border border;
    private final Alignment alignment;

    public Cell(Text text, Size size, Border border, Alignment alignment) {
        this.text = Objects.requireNonNull(text) ;
        this.size = Objects.requireNonNull(size);
        this.border = Objects.requireNonNull(border);
        this.alignment = Objects.requireNonNull(alignment);
    }

    public void printTo(Media media) {
        media.print(
                String.join(
                        border.top(size.width()),
                        border.left(),
                        text.bordered(size.width()),
                        border.right(),
                        border.bottom(size.width())
                )
        );
    }
}
