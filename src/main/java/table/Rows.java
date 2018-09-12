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
        final var maxLength = new Max<>(rows, row -> row.cellAmount().intValue());
        for (int i = 0; i < maxLength.intValue(); i++) {
            final var cell = i;
            rows.forEach(
                    row -> row.printCell(
                            cell,
                            media,
                            new Nat(
                                    new Max<>(rows, row1 -> row1.width(cell).intValue())
                            )
                    )
            );
        }
    }
}
