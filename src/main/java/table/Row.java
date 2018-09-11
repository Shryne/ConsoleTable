package table;

import table.output.Media;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class Row implements Content {
    private final Collection<String> cells;
    private final char delimiter;

    public Row(String... strings) {
        this(
                '|',
                List.of(strings)
        );
    }

    public Row(char delimiter, String... strings) {
        this(
                delimiter,
                List.of(strings)
        );
    }

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