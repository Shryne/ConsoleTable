package table;

import table.num.Nat;

/**
 * The border of a cell.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Border {
    private final char topCharacter;
    private final char leftCharacter;
    private final char rightCharacter;
    private final char bottomCharacter;

    public Border() {
        this('-', '|', '|', '-');
    }

    // TODO: The sides should probably get their own class, too
    public Border(char topCharacter, char leftCharacter, char rightCharacter, char bottomCharacter) {
        this.topCharacter = topCharacter;
        this.leftCharacter = leftCharacter;
        this.rightCharacter = rightCharacter;
        this.bottomCharacter = bottomCharacter;
    }

    public String top(Nat width) {
        return repeatedCharacter(topCharacter, width);
    }

    public String bottom(Nat width) {
        return repeatedCharacter(bottomCharacter, width);
    }

    public String left() {
        return leftCharacter + "";
    }

    public String right() {
        return rightCharacter + "";
    }

    // TODO: Create a class for that
    private static String repeatedCharacter(char toRepeat, Nat times) {
        return new String(
                new char[times.intValue()]
        ).replace("\0", toRepeat + "");
    }
}
