package table;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class Row {
    private final Collection<String> cells;

    public Row(String... strings) {
        this(List.of(strings));
    }

    public Row(Collection<String> cells) {
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
}
