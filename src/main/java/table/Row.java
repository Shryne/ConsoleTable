package table;

import table.num.Nat;
import table.output.Media;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a row of a table.
 * <p>Example: If the delimiter is "|" and the strings "1", "2", "3" are used, the result would be:</p>
 * <p>|1|2|3|</p>
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Row implements Content {
    private final List<String> cells;
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
    public Row(char delimiter, List<String> cells) {
        this.delimiter = delimiter;
        this.cells = cells;
    }

    // TODO: Test it
    public Nat width(int cell) {
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

    public Nat cellAmount() {
        return new Nat(cells.size());
    }

    // TODO: Test it
    // TODO: Think of a better way
    public void printCell(int cell, Media media, Nat width) {
        if (0 <= cell && cell < cells.size()) {
            media.print(
                    String.format("%" + width + "s", cells.get(cell))
            );
        }
    }
}