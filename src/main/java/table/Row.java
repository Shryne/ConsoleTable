package table;

import table.output.Media;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a row of a table.
 * <p>Example: If the delimiter is "|" and the strings "1", "2", "3" are used, the result would be:</p>
 * <p>|1|2|3|</p>
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Row implements Content {
    private final Collection<String> cells;
    private final char delimiter;

    /**
     * Uses '|' as the delimiter.
     * @param strings of the row.
     */
    public Row(String... strings) {
        this(
                '|',
                List.of(strings)
        );
    }

    /**
     * @param delimiter (/border) between the cells.
     * @param cells of the row.
     */
    public Row(char delimiter, String... cells) {
        this(
                delimiter,
                List.of(cells)
        );
    }

    /**
     * Primary constructor.
     * @param delimiter (/border) between the cells.
     * @param cells of the row.
     */
    public Row(char delimiter, Collection<String> cells) {
        this.delimiter = delimiter;
        this.cells = cells;
    }

    // TODO: Test it
    public Nat width() {
        return new Nat(
                cells.stream()
                        .map(String::length)
                        .max(Comparator.naturalOrder())
                        .orElse(0)
        );
    }

    @Override
    public void printTo(Media media) {
        if (!cells.isEmpty()) {
            final String d = String.valueOf(delimiter);
            media.print(d);
            cells.forEach(
                    it -> {
                        media.print(it);
                        media.print(d);
                    }
            );
        }
    }
}