package table;

import table.num.Max;
import table.num.Nat;
import table.output.Media;

import java.util.Collection;
import java.util.List;

/**
 * Combining multiple {@link Row}s together.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Rows implements Content {
    private final Collection<Row> rows;

    public Rows(Row... rows) {
        this(List.of(rows));
    }

    /**
     * @param rows
     */
    public Rows(Collection<Row> rows) {
        this.rows = rows;
    }

    @Override
    public void printTo(Media media) {
        final var maxLength = rows.stream()
                .map(Row::cellAmount)
                .max((a, b) -> Math.max(a.intValue(), b.intValue()))
                .orElse(new Nat(0));
        for (int i = 0; i < maxLength.intValue(); i++) {
            final var cell = i;
            final var maxWidth = rows.stream()
                    .map(it -> it.width(cell))
                    .max((a, b) -> Math.max(a.intValue(), b.intValue()))
                    .orElse(new Nat(0));
            rows.forEach(
                    row -> row.printCell(cell, media, maxWidth)
            );
        }
    }
}
