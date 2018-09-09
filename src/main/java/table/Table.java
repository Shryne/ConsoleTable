package table;

import table.output.Media;

/**
 *
 */
public final class Table {
    private final Border border;
    private final Rows rows;

    public Table(Rows rows) {
        this(
                new Border(),
                rows
        );
    }

    /**
     * Primary constructor.
     */
    public Table(Border border, Rows rows) {
        this.border = border;
        this.rows = rows;
    }

    public void printTo(Media media) {
        media.print(
                String.join(
                        border.top(rows.maxWidth()), "\n",
                        rows.toString(),
                        border.bottom(rows.maxWidth()), "\n"
                )
        );
    }
}
