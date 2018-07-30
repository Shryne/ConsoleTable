package table;

import java.util.Objects;

/**
 * The text inside a cell of a table.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Text {
    private final String string;

    public Text(String string) {
        this.string = Objects.requireNonNull(string);
    }

    public
}
