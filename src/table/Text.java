package table;

import java.util.Objects;

/**
 * The text inside a cell of a table.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Text {
    private final CharSequence txt;
    private final CharSequence endString;

    public Text(CharSequence txt, CharSequence endString) {
        this.txt = Objects.requireNonNull(txt);
        this.endString = Objects.requireNonNull(endString);
    }

    public String bordered(Nat charAmount) {
        if (txt.length() <= charAmount.intValue()) {
            return txt.toString();
        }
        if (txt.length() >= charAmount.intValue()) {
            return txt.subSequence(0, txt.length() - charAmount.intValue()).toString() + endString;
        }
        return endString.subSequence(0, charAmount.intValue()).toString();
    }
}
