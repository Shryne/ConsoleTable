package table;

import table.output.Media;

import java.util.Collection;
import java.util.List;

public final class Rows implements Content {
    private final Collection<Row> rows;

    public Rows(Row... rows) {
        this(List.of(rows));
    }

    public Rows(Collection<Row> rows) {
        this.rows = rows;
    }

    public Nat width() {
        return rows.stream()
                .map(Row::width)
                .max((a, b) -> Math.max(a.intValue(), b.intValue()))
                .orElse(new Nat(0));
    }

    @Override
    public void printTo(Media media) {
        // TODO: Implement it
    }
}
